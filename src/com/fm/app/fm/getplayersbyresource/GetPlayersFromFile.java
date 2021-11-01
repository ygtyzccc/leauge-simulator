package com.fm.app.fm.getplayersbyresource;

import com.fm.app.fm.player.Player;
import com.fm.app.fm.player.positions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class GetPlayersFromFile {
    private BufferedReader m_br;
    private final String m_path;
    private final ArrayList<String> m_dataArray = new ArrayList<>();
    private final ArrayList<String> m_positionsArray = new ArrayList<>();
    private final ArrayList<String> m_namesArray = new ArrayList<>();
    private final ArrayList<Integer> m_attackSkillsArray = new ArrayList<>();
    private final ArrayList<Integer> m_defenceSkillsArray = new ArrayList<>();
    private final ArrayList<Player> m_squad = new ArrayList<>();


    public GetPlayersFromFile(String path) throws IOException {
        m_path = path;
        m_br = new BufferedReader(new FileReader(m_path));
        this.run();
    }

    private void getDataFromFile() throws IOException
    {
        String data;

        while ((data = m_br.readLine()) != null)
            m_dataArray.add(data);
    }

    private void parseData()
    {
        for(String data: m_dataArray) {
            m_positionsArray.add(data.split("[,]+")[1]);
            m_namesArray.add(data.split("[,]+")[2]);
            m_attackSkillsArray.add(Integer.parseInt(data.split("[,]+")[3]));
            m_defenceSkillsArray.add(Integer.parseInt(data.split("[,]+")[4]));

        }
    }

    private Goalkeeper ofGoalKeeper(int index)
    {
        return new Goalkeeper(m_namesArray.get(index), m_defenceSkillsArray.get(index));
    }

    private LeftBack ofLeftBack(int index)
    {
        return new LeftBack(m_namesArray.get(index),m_attackSkillsArray.get(index),  m_defenceSkillsArray.get(index));
    }

    private Defence ofDefence(int index)
    {
        return new Defence(m_namesArray.get(index),m_attackSkillsArray.get(index),  m_defenceSkillsArray.get(index));
    }

    private RightBack ofRightBack(int index)
    {
        return new RightBack(m_namesArray.get(index),m_attackSkillsArray.get(index),  m_defenceSkillsArray.get(index));
    }

    private Middlefield ofMiddlefield(int index)
    {
        return new Middlefield(m_namesArray.get(index),m_attackSkillsArray.get(index),  m_defenceSkillsArray.get(index));
    }

    private AttackingMiddleField ofAttackingMiddleField(int index)
    {
        return new AttackingMiddleField(m_namesArray.get(index),m_attackSkillsArray.get(index),  m_defenceSkillsArray.get(index));
    }

    private Forward ofForward(int index)
    {
        return new Forward(m_namesArray.get(index),m_attackSkillsArray.get(index),  m_defenceSkillsArray.get(index));
    }

    private void ofPlayers() throws IOException
    {
        for (int i = 0; i < 11; ++i) {
            if (m_positionsArray.get(i).equals("GK"))
                m_squad.add(ofGoalKeeper(i));

            else if (m_positionsArray.get(i).equals("LB"))
                m_squad.add(ofLeftBack(i));

            else if (m_positionsArray.get(i).equals("DFC"))
                m_squad.add(ofDefence(i));

            else if (m_positionsArray.get(i).equals("RB"))
                m_squad.add(ofRightBack(i));

            else if (m_positionsArray.get(i).equals("MID"))
                m_squad.add(ofMiddlefield(i));

            else if (m_positionsArray.get(i).equals("AMC"))
                m_squad.add(ofAttackingMiddleField(i));

            else if (m_positionsArray.get(i).equals("FWD"))
                m_squad.add(ofForward(i));

            else
                throw new IOException("Dosya formati bozuk");

        }
    }

    public ArrayList<Player> getSquad() {
        return m_squad;
    }

    public void run() throws IOException
    {
        this.getDataFromFile();
        this.parseData();
        this.ofPlayers();
    }

    public void displaySquad()
    {
        for(Player player: this.getSquad())
            System.out.println(player);
    }
}
