package com.fm.app.fm.league;

import com.fm.app.fm.team.Team;
import com.fm.app.fm.team.trligteams.Besiktas;
import com.fm.app.fm.team.trligteams.Fenerbahce;
import com.fm.app.fm.team.trligteams.Galatasaray;
import com.fm.app.fm.team.trligteams.Trabzonspor;


public class LigApp {
    private Team m_fenerbahce = new Fenerbahce();
    private Team m_galatasaray = new Galatasaray();
    private Team m_besiktas = new Besiktas();
    private Team m_trabzonspor = new Trabzonspor();

    private static void doWorkForHomeWin(Match match)
    {
        match.getHome().incrementOfPoint(3);
    }

    private static void doWorkForVisitorWin(Match match)
    {
        match.getVisitor().incrementOfPoint(3);
    }

    private static void doWorkForTieGame(Match match)
    {
        match.getHome().incrementOfPoint(1);
    }


    private static void doWorkForStatistics(Match match)
    {
        if (match.getHomeGoal() > match.getVisitorGoal())
            doWorkForHomeWin(match);

        else if (match.getHomeGoal() < match.getVisitorGoal())
            doWorkForVisitorWin(match);

        else
            doWorkForTieGame(match);
    }

    public LigApp() {


    }

    public void leagueRun()
    {
        Match m1 = new Match(m_fenerbahce, m_galatasaray);
        m1.playMatch();
        m1.displayScoreboardWithDetails();
        doWorkForStatistics(m1);
        System.out.println("**********");
        Match m2 = new Match(m_besiktas, m_trabzonspor);
        m2.playMatch();
        m2.displayScoreboardWithDetails();
        System.out.println("**********");
        Match m3 = new Match(m_fenerbahce, m_besiktas);
        m3.playMatch();
        m3.displayScoreboardWithDetails();
        System.out.println("**********");
        Match m4 = new Match(m_galatasaray, m_trabzonspor);
        m4.playMatch();
        m4.displayScoreboardWithDetails();
        Match m5 = new Match(m_besiktas, m_galatasaray);
        m5.playMatch();
        m5.displayScoreboardWithDetails();
        Match m6 = new Match(m_fenerbahce, m_trabzonspor);
        m6.playMatch();
        m6.displayScoreboardWithDetails();





    }

    public String formatLeagueTable() {


        String table = "Position Club Points\n";
        //...
        TODO:
        return table;
    }
}
