package com.fm.app.fm.team;


import com.fm.app.fm.player.Player;
import java.util.ArrayList;

public abstract class Team {

    private String m_teamName;
    protected ArrayList <Player> m_squad = new ArrayList<>();
    private int m_point;
    private int m_totalGoalAgainst;
    private int m_totalGoalScore;
    private int m_totalMatchPlayed;

    private void createSquad(ArrayList<Player> players)
    {
        for (Player player : players) {
            addNewPlayer(player);
        }
    }

    private void addNewPlayer(Player player)
    {
        m_squad.add(player);
    }

    public Team(String teamName)
    {
        m_teamName = teamName;
    }

    public int getPoint() {
        return m_point;
    }

    public void incrementOfPoint(int point) {
        m_point += point;
    }

    public int getTotalGoalScore() {
        return m_totalGoalScore;
    }

    public int getTotalGoalAgainst() {
        return m_totalGoalAgainst;
    }

    public int getTotalMatchPlayed() {
        return m_totalMatchPlayed;
    }

    public ArrayList<Player> getTeamSquadArray()
    {
        return m_squad;
    }

    public String toString()
    {
        return m_teamName;
    }

}
