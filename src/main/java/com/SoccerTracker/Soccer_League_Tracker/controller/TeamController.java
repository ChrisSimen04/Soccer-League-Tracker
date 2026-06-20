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

import com.SoccerTracker.Soccer_League_Tracker.model.Team;
import com.SoccerTracker.Soccer_League_Tracker.service.TeamService;

@RestController
@RequestMapping("/teams")
@CrossOrigin(origins = "*")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping("/{id}")
    public Team getTeamById(@PathVariable Long id) {
        return teamService.getTeamById(id);
    }

    @PostMapping
    public Team addTeam(@RequestBody Team team) {
        return teamService.saveTeam(team);
    }

    @PutMapping("/{id}")
    public Team updateTeam(@PathVariable Long id, @RequestBody Team updatedTeam) {
        Team existingTeam = teamService.getTeamById(id);

        if (existingTeam != null) {
            existingTeam.setName(updatedTeam.getName());
            existingTeam.setCity(updatedTeam.getCity());
            existingTeam.setStadium(updatedTeam.getStadium());
            existingTeam.setManager(updatedTeam.getManager());
            existingTeam.setLeague(updatedTeam.getLeague());

            return teamService.saveTeam(existingTeam);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable Long id) {
        teamService.deleteTeam(id);
    }
}