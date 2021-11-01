package com.fm.app.fm.team.trligteams;

import com.fm.app.fm.getplayersbyresource.GetPlayersFromFile;
import com.fm.app.fm.team.Team;

import java.io.IOException;
import java.util.ArrayList;

public class Besiktas extends Team {

    public Besiktas()
    {
        super("Besiktas");
        this.ofSquad();
    }

    public void ofSquad() {
        try {
            GetPlayersFromFile getPlayersFromFile =
                    new GetPlayersFromFile("C:/Users/ASUS/Desktop/Teams/" + super.toString() + ".txt");

            super.m_squad = getPlayersFromFile.getSquad();
        }
        catch (IOException ignore) {
            System.out.println("Dosya hatasindan dolayi takim yaratilamadi.");
        }
    }
}
