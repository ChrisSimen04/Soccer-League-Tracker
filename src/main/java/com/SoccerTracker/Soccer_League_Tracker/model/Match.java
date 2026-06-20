package com.SoccerTracker.Soccer_League_Tracker.model;

import java.time.LocalDateTime;

public class Match {
	private Long id;
	private String homeTeam;
	private String awayTeam;
	private int homeScore;
	private int awayScore;
	private LocalDateTime matchDate;
	private String matchDay;
	
	public Match() {}

	
	public Match(Long id, String homeTeam, String awayTeam, int homeScore, int awayScore, LocalDateTime matchDate,
			String matchDay) {
		super();
		this.id = id;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.homeScore = homeScore;
		this.awayScore = awayScore;
		this.matchDate = matchDate;
		this.matchDay = matchDay;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getHomeTeam() {
		return homeTeam;
	}
	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}
	public String getAwayTeam() {
		return awayTeam;
	}
	public void setAwayTeam(String awayTeam) {
		this.awayTeam = awayTeam;
	}
	public int getHomeScore() {
		return homeScore;
	}
	public void setHomeScore(int homeScore) {
		this.homeScore = homeScore;
	}
	public int getAwayScore() {
		return awayScore;
	}
	public void setAwayScore(int awayScore) {
		this.awayScore = awayScore;
	}
	public LocalDateTime getMatchDate() {
		return matchDate;
	}
	public void setMatchDate(LocalDateTime matchDate) {
		this.matchDate = matchDate;
	}
	public String getMatchDay() {
		return matchDay;
	}
	public void setMatchDay(String matchDay) {
		this.matchDay = matchDay;
	}
	
	
}
