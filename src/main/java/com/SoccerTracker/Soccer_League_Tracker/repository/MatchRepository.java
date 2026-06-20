package com.SoccerTracker.Soccer_League_Tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SoccerTracker.Soccer_League_Tracker.model.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

}