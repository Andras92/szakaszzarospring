package com.example.Superheroes.Service;

import com.example.Superheroes.Excepcion.ValidationException;
import com.example.Superheroes.Model.Superhero;
import com.example.Superheroes.Repo.SuperheroJpaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SuperheroService {
    private final SuperheroJpaRepo superheroJpaRepo;

    public void create(Superhero superhero) {
        validateSuperhero(superhero);
        superheroJpaRepo.save(superhero);
    }

    public Superhero update(Superhero superhero, String id) {
        validateSuperhero(superhero);
        return superheroJpaRepo.save(superhero.toBuilder().id(id).build());
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
        if (!StringUtils.hasText(superhero.getId())) {
            throw new ValidationException("Nincs ilyen id");
        }

    }
}
