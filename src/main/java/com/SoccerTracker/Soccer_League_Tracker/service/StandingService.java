package com.SoccerTracker.Soccer_League_Tracker.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.SoccerTracker.Soccer_League_Tracker.model.Match;
import com.SoccerTracker.Soccer_League_Tracker.model.Standing;
import com.SoccerTracker.Soccer_League_Tracker.model.Team;
import com.SoccerTracker.Soccer_League_Tracker.repository.MatchRepository;
import com.SoccerTracker.Soccer_League_Tracker.repository.TeamRepository;


/*
Retrieves all teams.
Gives every team a starting record of zero.
Retrieves all matches.
Updates each team’s statistics.
Awards points.
Sorts the league table.

The sorting order is:
Most points
Best goal difference
Most goals scored
Alphabetical team name
 
 */
@Service
public class StandingService {

    private final TeamRepository teamRepository;
    private final MatchRepository matchRepository;

    public StandingService(
            TeamRepository teamRepository,
            MatchRepository matchRepository) {

        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }

    public List<Standing> getStandings() {

        List<Team> teams = teamRepository.findAll();
        List<Match> matches = matchRepository.findAll();

        Map<String, Standing> standingMap = new HashMap<>();

        // Add every registered team with zero statistics.
        for (Team team : teams) {
            standingMap.put(
                    team.getName(),
                    new Standing(team.getName())
            );
        }

        // Calculate standings from all saved matches.
        for (Match match : matches) {

            Standing homeStanding = standingMap.computeIfAbsent(
                    match.getHomeTeam(),
                    Standing::new
            );

            Standing awayStanding = standingMap.computeIfAbsent(
                    match.getAwayTeam(),
                    Standing::new
            );

            homeStanding.recordMatch(
                    match.getHomeScore(),
                    match.getAwayScore()
            );

            awayStanding.recordMatch(
                    match.getAwayScore(),
                    match.getHomeScore()
            );
        }

        List<Standing> standings =
                new ArrayList<>(standingMap.values());

        standings.sort(
                Comparator.comparingInt(Standing::getPoints)
                        .reversed()
                        .thenComparing(
                                Comparator.comparingInt(
                                        Standing::getGoalDifference
                                ).reversed()
                        )
                        .thenComparing(
                                Comparator.comparingInt(
                                        Standing::getGoalsFor
                                ).reversed()
                        )
                        .thenComparing(Standing::getTeam)
        );

        return standings;
    }
}