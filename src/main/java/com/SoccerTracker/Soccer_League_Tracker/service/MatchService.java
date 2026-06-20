package com.SoccerTracker.Soccer_League_Tracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SoccerTracker.Soccer_League_Tracker.model.Match;
import com.SoccerTracker.Soccer_League_Tracker.repository.MatchRepository;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    public Match getMatchById(Long id) {
        return matchRepository.findById(id).orElse(null);
    }

    public Match saveMatch(Match match) {
        return matchRepository.save(match);
    }

    public void deleteMatch(Long id) {
        matchRepository.deleteById(id);
    }
}
