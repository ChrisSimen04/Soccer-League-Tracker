package com.SoccerTracker.Soccer_League_Tracker.model;

public class Standing {

    private String teamName;
    private int played;
    private int wins;
    private int draws;
    private int losses;
    private int goalsFor;
    private int goalsAgainst;
    private int goalDifference;
    private int points;

    public Standing(String teamName) {
        this.teamName = teamName;
    }

    public void recordMatch(int goalsScored, int goalsAllowed) {
        played++;
        goalsFor += goalsScored;
        goalsAgainst += goalsAllowed;
        goalDifference = goalsFor - goalsAgainst;

        if (goalsScored > goalsAllowed) {
            wins++;
            points += 3;
        } else if (goalsScored == goalsAllowed) {
            draws++;
            points += 1;
        } else {
            losses++;
        }
    }

    public String getTeamName() {
        return teamName;
    }

    public int getPlayed() {
        return played;
    }

    public int getWins() {
        return wins;
    }

    public int getDraws() {
        return draws;
    }

    public int getLosses() {
        return losses;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public int getGoalDifference() {
        return goalDifference;
    }

    public int getPoints() {
        return points;
    }
}