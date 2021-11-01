package com.fm.app.fm.player;

public abstract class Player {

    protected String m_playerName;

    public Player(String name)
    {
        m_playerName = name;
    }
    
    public String getPlayerName() {
        return m_playerName;
    }

    public String toString()
    {
        return getPlayerName();
    }

    public abstract double getAttack();

    public abstract double getDefence();

    public abstract int getKeepingAtt();

}
