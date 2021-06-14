package com.example.Superheroes.Controller;

import com.example.Superheroes.Model.Team;
import com.example.Superheroes.Service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/teams")
public class TeamController {
    private final TeamService teamService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Team team) {
        teamService.create(team);
    }

    @GetMapping("")
    public List<Team> findAll() {
        return teamService.findAll();
    }

    @PutMapping("")
    public Team update(@RequestBody Team team, @RequestParam String id) {
        return teamService.update(team,id);
    }


    @GetMapping("/{id}")
    public Optional<Team> findById(@PathVariable String id) {
        return teamService.findById(id);
    }
}
