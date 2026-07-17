package com.SoccerTracker.Soccer_League_Tracker.model;

public class Standing {

    private String team;
    private int matchesPlayed;
    private int wins;
    private int losses;
    private int draws;
    private int goalsFor;
    private int goalsAgainst;
    private int goalDifference;
    private int points;

    public Standing() {
    }

    public Standing(String team) {
        this.team = team;
    }

    public Standing(
            String team,
            int matchesPlayed,
            int wins,
            int losses,
            int draws,
            int goalsFor,
            int goalsAgainst,
            int goalDifference,
            int points) {

        this.team = team;
        this.matchesPlayed = matchesPlayed;
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
        this.goalsFor = goalsFor;
        this.goalsAgainst = goalsAgainst;
        this.goalDifference = goalDifference;
        this.points = points;
    }

    public void recordMatch(int goalsScored, int goalsAllowed) {

        matchesPlayed++;

        goalsFor += goalsScored;
        goalsAgainst += goalsAllowed;

        goalDifference = goalsFor - goalsAgainst;

        if (goalsScored > goalsAllowed) {
            wins++;
            points += 3;
        } else if (goalsScored == goalsAllowed) {
            draws++;
            points++;
        } else {
            losses++;
        }
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public void setGoalsFor(int goalsFor) {
        this.goalsFor = goalsFor;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(int goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    public int getGoalDifference() {
        return goalDifference;
    }

    public void setGoalDifference(int goalDifference) {
        this.goalDifference = goalDifference;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}