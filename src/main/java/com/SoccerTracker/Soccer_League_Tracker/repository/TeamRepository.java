package com.SoccerTracker.Soccer_League_Tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SoccerTracker.Soccer_League_Tracker.model.Team;


public interface TeamRepository extends JpaRepository<Team, Long> {}