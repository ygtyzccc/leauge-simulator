package com.fm.app.fm.player.positions;

import com.fm.app.fm.player.Player;

public class LeftBack extends Player {
    private int m_keepingAtt;
    private double m_defence;
    private double m_attack;

    public LeftBack(String name, int attack, int defence)
    {
        super(name);
        m_attack = attack * 1.1;
        m_defence = defence * 1.1;
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
