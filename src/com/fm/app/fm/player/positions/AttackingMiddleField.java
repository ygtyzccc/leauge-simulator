package com.fm.app.fm.player.positions;

import com.fm.app.fm.player.Player;

public class AttackingMiddleField extends Player {
    private int m_keepingAtt;
    private double m_attack;
    private double m_defence;

    public AttackingMiddleField(String name, int attack, int defence)
    {
        super(name);
        m_attack = attack * 1.2;
        m_defence = defence;
    }


    public int getKeepingAtt() {
        return m_keepingAtt;
    }

    public double getAttack() {
        return m_attack;
    }

    public double getDefence() {
        return m_defence;
    }
}
