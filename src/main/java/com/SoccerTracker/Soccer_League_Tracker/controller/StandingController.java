package com.SoccerTracker.Soccer_League_Tracker.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SoccerTracker.Soccer_League_Tracker.model.Standing;
import com.SoccerTracker.Soccer_League_Tracker.service.StandingService;

@RestController
@RequestMapping("/standings")
@CrossOrigin(origins = "http://localhost:5173")
public class StandingController {

    private final StandingService standingService;

    public StandingController(StandingService standingService) {
        this.standingService = standingService;
    }

    @GetMapping
    public List<Standing> getStandings() {
        return standingService.getStandings();
    }
}
