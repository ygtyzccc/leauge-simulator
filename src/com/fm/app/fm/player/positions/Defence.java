package com.fm.app.fm.player.positions;

import com.fm.app.fm.player.Player;

public class Defence extends Player {
    private int m_keepingAtt;
    private double m_defence;
    private double m_attack;

    public Defence(String name, int attack, int defence)
    {
        super(name);
        m_attack = attack * 0.8;
        m_defence = defence * 1.2;
    }

    public int getKeepingAtt() {
        return m_keepingAtt;
    }

    public double getDefence() {
        return m_defence;
    }

    public double getAttack() {
        return m_attack;
    }
}
