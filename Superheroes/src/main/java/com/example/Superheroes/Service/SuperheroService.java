package com.example.Superheroes.Service;

import com.example.Superheroes.Excepcion.ValidationException;
import com.example.Superheroes.Model.Superhero;
import com.example.Superheroes.Model.Team;
import com.example.Superheroes.Repo.SuperheroJpaRepo;
import com.example.Superheroes.Repo.TeamJpaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SuperheroService {
    private final SuperheroJpaRepo superheroJpaRepo;
    private final TeamJpaRepo teamJpaRepo;

    public void create(Superhero superhero) {
        validateSuperhero(superhero);
        String teamid = superhero.getTeam().getId();
        Team team = teamJpaRepo.findById(teamid).orElse(null);
        superheroJpaRepo.save(Superhero.builder()
                .name(superhero.getName())
                .universe(superhero.getUniverse())
                .team(team)
                .build()
        );
    }

    public Superhero update(Superhero superhero, String id) {
        validateSuperhero(superhero);
        Team team = teamJpaRepo.findById(id).orElse(null);
        return superheroJpaRepo.save(superhero.toBuilder()
                .id(id)
                .universe(superhero.getUniverse())
                .name(superhero.getName())
                .team(team)
                .build());
    }

    public List<Superhero> findAll() {
        return superheroJpaRepo.findAll();
    }

    public Optional<Superhero> findById(String id) {
        return superheroJpaRepo.findById(id);
    }

    private void validateSuperhero(Superhero superhero) throws ValidationException {

        if (!StringUtils.hasText(superhero.getName())){
            throw new ValidationException("Nincs ilyen nevű");
        }
        if (superhero.getTeam()==null) {
            throw new ValidationException("Nincs ilyen csapat");
        }
        if (superhero.getUniverse()==null) {
            throw new ValidationException("Nincs ilyen univerzum");
        }
    }
}
