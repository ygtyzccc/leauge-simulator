package com.fm.app.fm.league;

import com.fm.app.fm.player.Player;
import com.fm.app.fm.team.Team;
import util.RandomUtil;

import java.util.ArrayList;
import java.util.Random;

public class Match {

    private final static Random R = new Random();
    private final Team m_home;
    private final Team m_visitor;
    private int m_homeGoal;
    private int m_visitorGoal;
    private final int m_homeKeepingAtt;
    private final int m_visitorKeepingAtt;
    private final int m_totalHomeDefenceAtt;
    private final int m_totalHomeAttackAtt;
    private final int m_totalVisitorDefenceAtt;
    private final int m_totalVisitorAttackAtt;
    private final ArrayList<Player> m_scorersListHomeArray = new ArrayList<>();
    private final ArrayList<Player> m_scorersListVisitorArray = new ArrayList<>();
    private final ArrayList<Integer> m_goalMinutesHomeArray = new ArrayList<>();
    private final ArrayList<Integer> m_goalMinutesVisitorArray = new ArrayList<>();

    private int countShots()
    {
        ;
        int count = 0;

        //...

        return count;

    }

    private static Player[] canBeScoredPlayer(int n, int[] playerIndexNo, ArrayList<Player> squad)
    {
        Player[] canBeScoreArray = new Player[n];

        for(int i = 0; i < n; ++i)
            canBeScoreArray[i] = squad.get(playerIndexNo[i]);

        return canBeScoreArray;
    }

    private static Player getWhoScoreGoal(Player[] canbeScoredplayer)
    {
        Player whoScoreGoal;

        if(canbeScoredplayer[0].getAttack() > canbeScoredplayer[1].getAttack())
            whoScoreGoal = canbeScoredplayer[0];
        else
            whoScoreGoal = canbeScoredplayer[1];

        if(whoScoreGoal.getAttack() > canbeScoredplayer[2].getAttack())
            return whoScoreGoal;
        else
            return canbeScoredplayer[2];

    }

    private static Player selectWhoScoreTheGoal(ArrayList<Player> squad)
    {
        int[] canBeScoredIndexNo = RandomUtil.toRandomDifIntArray(0,11,3);
        Player[] canBeScoredPlayer = canBeScoredPlayer(3 ,canBeScoredIndexNo, squad);
        Player whoScoreGoal = getWhoScoreGoal(canBeScoredPlayer);

        return whoScoreGoal;

    }

    private static int calculateTotalDefenceAtt(ArrayList<Player> squad)
    {
        int totalDef = 0;

        for (int i = 1; i < squad.size(); ++i) {

           totalDef += squad.get(i).getDefence();
        }

        return totalDef;
    }

    private static int calculateTotalAttackAtt(ArrayList<Player> squad)
    {
        int totalAtt = 0;

        for (int i = 1; i < squad.size(); ++i) {

            totalAtt += squad.get(i).getAttack();
        }

        return totalAtt;
    }

    private static int setKeepingAtt(Team team)
    {
        return team.getTeamSquadArray().get(0).getKeepingAtt();
    }

    private int calculateHomeTotalAttackAtt()
    {
        return calculateTotalAttackAtt(m_home.getTeamSquadArray());
    }

    private int calculateHomeTotalDefenceAtt()
    {
        return calculateTotalDefenceAtt(m_home.getTeamSquadArray());
    }

    private int calculateVisitorTotalAttackAtt()
    {
        return calculateTotalAttackAtt(m_visitor.getTeamSquadArray());
    }

    private int calculateVisitorTotalDefenceAtt()
    {
        return calculateTotalDefenceAtt(m_visitor.getTeamSquadArray());
    }

    private static void addWhoScoreGoal(Team team, ArrayList<Player> scorerList)
    {
        Player scorer =  selectWhoScoreTheGoal(team.getTeamSquadArray());
        scorerList.add(scorer);
    }

    private static boolean isGoal(int attack, int defence, int keepingAtt)
    {
        int keeperFactor = keepingAtt / 20;
        int randomFormForPositionAttack = R.nextInt(150) - 50;
        int randomFormForPositionDefence = R.nextInt(150) - 50;

        if ((attack + randomFormForPositionAttack) - (defence + randomFormForPositionDefence) > 10) {
            int randomNumber = R.nextInt(keeperFactor);
            if (randomNumber == 0)
                return true;
        }

        return false;
    }

    private static int goalChance(int attack, int defence, int keepingAttDefender, int attackSideScore, Team team,
                                  ArrayList<Player> scorersList, ArrayList<Integer> goalMinutes, int minute)
    {
       if (isGoal(attack, defence, keepingAttDefender)){
           goalMinutes.add(minute);
           addWhoScoreGoal(team, scorersList);
           return ++attackSideScore;
       }

        return attackSideScore;
    }

    private void goalChanceForHome(int minute)
    {
        m_homeGoal = goalChance(m_totalHomeAttackAtt, m_totalVisitorDefenceAtt,m_visitorKeepingAtt,
                m_homeGoal, m_home, m_scorersListHomeArray, m_goalMinutesHomeArray, minute);
    }

    private void goalChanceForVisitor(int minute)
    {
        m_visitorGoal = goalChance(m_totalVisitorAttackAtt, m_totalHomeDefenceAtt,m_homeKeepingAtt,
                m_visitorGoal,m_visitor , m_scorersListVisitorArray, m_goalMinutesVisitorArray, minute);
    }

    private static void readWhoScores(ArrayList<Player> scorers)
    {
        for (Player player: scorers)
            System.out.println(player);
    }

    private static void readGoalMinutes(ArrayList<Integer> goalMinutesArray)
    {
        for(int minute : goalMinutesArray)
            System.out.println(minute);
    }

    private static void readGoalMinutesAndScorers(ArrayList<Player> scorersArray, ArrayList<Integer> goalMinutesArray)
    {
        for(int i = 0; i < goalMinutesArray.size(); ++i)
            System.out.printf("%d' %s\n", goalMinutesArray.get(i), scorersArray.get(i));
    }

    private void  readGoalMinutesAndScorersHome()
    {
        readGoalMinutesAndScorers(m_scorersListHomeArray, m_goalMinutesHomeArray);
    }

    private void  readGoalMinutesAndScorersVisitor()
    {
        readGoalMinutesAndScorers(m_scorersListVisitorArray, m_goalMinutesVisitorArray);
    }

    private void readGoalMinutesHome()
    {
        readGoalMinutes(m_goalMinutesHomeArray);
    }

    private void readGoalMinutesVisitor()
    {
        readGoalMinutes(m_goalMinutesVisitorArray);
    }

    private void readWhoScoresHome()
    {
        readWhoScores(m_scorersListHomeArray);
    }

    private void readWhoScoresVisitor()
    {
        readWhoScores(m_scorersListVisitorArray);
    }

    public Match(Team home, Team visitor)
    {
        m_home = home;
        m_visitor = visitor;

        m_homeKeepingAtt = setKeepingAtt(m_home);
        m_totalHomeDefenceAtt = this.calculateHomeTotalDefenceAtt();
        m_totalHomeAttackAtt = this.calculateHomeTotalAttackAtt();

        m_visitorKeepingAtt = setKeepingAtt(m_visitor);
        m_totalVisitorDefenceAtt = this.calculateVisitorTotalDefenceAtt();
        m_totalVisitorAttackAtt = this.calculateVisitorTotalAttackAtt();
    }

    public void playMatch()
    {
        for (int i = 0; i < 10; ++i) {
            this.goalChanceForHome(i * 10 + R.nextInt(10));
            this.goalChanceForVisitor(i * 10+ R.nextInt(10));
        }
    }

    public Team getHome()
    {
        return m_home;
    }

    public Team getVisitor()
    {
        return m_visitor;
    }

    public int getHomeGoal() {
        return m_homeGoal;
    }

    public int getVisitorGoal() {
        return m_visitorGoal;
    }

    public int getTotalHomeDefenceAtt() {
        return m_totalHomeDefenceAtt;
    }

    public int getTotalHomeAttackAtt() {
        return m_totalHomeAttackAtt;
    }

    public int getTotalVisitorDefenceAtt() {
        return m_totalVisitorDefenceAtt;
    }

    public int getTotalVisitorAttackAtt() {
        return m_totalVisitorAttackAtt;
    }

    public void displayWhoScoreGoals()
    {
        this.readWhoScoresHome();
        System.out.println("------------------");
        this.readWhoScoresVisitor();
    }

    public void displayGoalMinutes()
    {
        this.readGoalMinutesHome();
        this.readGoalMinutesVisitor();
    }

    public String toStringScoreboard()
    {
        return String.format("%s: %d - %s: %d\n\r",m_home, m_homeGoal, m_visitor, m_visitorGoal);
    }

    public String toStringGoalsAndMinutes(int minute, Player scorer)
    {
        return String.format("%d' %s\n",minute, scorer);
    }

    public void displayScoreboard()
    {
        System.out.print(toStringScoreboard());
    }

    public void displayScoreboardWithDetails()
    {
        this.displayScoreboard();
        this.readGoalMinutesAndScorersHome();
        System.out.println("------------------");
        this.readGoalMinutesAndScorersVisitor();
    }
}
