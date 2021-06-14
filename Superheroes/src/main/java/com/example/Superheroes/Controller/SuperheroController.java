package com.example.Superheroes.Controller;

import com.example.Superheroes.Model.Superhero;
import com.example.Superheroes.Model.Team;
import com.example.Superheroes.Service.SuperheroService;
import com.example.Superheroes.Service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/superhero")
public class SuperheroController {
    private final SuperheroService superheroService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Superhero superhero) {
        superheroService.create(superhero);
    }

    @GetMapping("")
    public List<Superhero> findAll() {
        return superheroService.findAll();
    }

    @PutMapping("")
    public Superhero update(@RequestBody Superhero superhero, @RequestParam String id) {
        return superheroService.update(superhero,id);
    }
    @GetMapping("/{id}")
    public Optional<Superhero> findById(@PathVariable String id) {
        return superheroService.findById(id);
    }
}

