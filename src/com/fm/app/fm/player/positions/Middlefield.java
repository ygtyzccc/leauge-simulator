package com.fm.app.fm.player.positions;

import com.fm.app.fm.player.Player;

public class Middlefield extends Player {
    private int m_keepingAtt;
    private int m_defence;
    private int m_attack;

    public Middlefield(String name, int attack, int defence)
    {
        super(name);
        m_attack = attack;
        m_defence = defence;
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
