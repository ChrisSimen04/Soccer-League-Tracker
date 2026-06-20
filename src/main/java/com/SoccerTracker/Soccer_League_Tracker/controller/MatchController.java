package com.SoccerTracker.Soccer_League_Tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SoccerTracker.Soccer_League_Tracker.model.Match;
import com.SoccerTracker.Soccer_League_Tracker.service.MatchService;

@RestController
@RequestMapping("/matches")
@CrossOrigin(origins = "*")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @GetMapping
    public List<Match> getAllMatches() {
        return matchService.getAllMatches();
    }

    @GetMapping("/{id}")
    public Match getMatchById(@PathVariable Long id) {
        return matchService.getMatchById(id);
    }

    @PostMapping
    public Match addMatch(@RequestBody Match match) {
        return matchService.saveMatch(match);
    }

    @PutMapping("/{id}")
    public Match updateMatch(@PathVariable Long id, @RequestBody Match updatedMatch) {
        Match existingMatch = matchService.getMatchById(id);

        if (existingMatch != null) {
            existingMatch.setHomeTeam(updatedMatch.getHomeTeam());
            existingMatch.setAwayTeam(updatedMatch.getAwayTeam());
            existingMatch.setHomeScore(updatedMatch.getHomeScore());
            existingMatch.setAwayScore(updatedMatch.getAwayScore());
            existingMatch.setMatchDate(updatedMatch.getMatchDate());
            existingMatch.setMatchDay(updatedMatch.getMatchDay());

            return matchService.saveMatch(existingMatch);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteMatch(@PathVariable Long id) {
        matchService.deleteMatch(id);
    }
}