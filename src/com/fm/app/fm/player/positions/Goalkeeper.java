package com.fm.app.fm.player.positions;

import com.fm.app.fm.player.Player;

public class Goalkeeper extends Player {

    private int m_keepingAtt;


    public Goalkeeper(String name, int keepingAtt) {
        super(name);
        m_keepingAtt = keepingAtt;
    }

    public int getKeepingAtt() {
        return m_keepingAtt;
    }

    @Override
    public double getAttack() {
        return 0;
    }

    @Override
    public double getDefence() {
        return 0;
    }
}


