package com.fm.app.fm.player.positions;

import com.fm.app.fm.player.Player;

public class Forward extends Player {
    private int m_keepingAtt;
    private int m_defence;
    private int m_attack;

    public Forward(String name, int attack, int defence)
    {
        super(name);
        m_defence = defence;
        m_attack = attack;

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
