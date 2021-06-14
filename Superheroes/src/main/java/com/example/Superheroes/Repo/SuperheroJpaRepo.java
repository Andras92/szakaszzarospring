package com.example.Superheroes.Repo;

import com.example.Superheroes.Model.Superhero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuperheroJpaRepo extends JpaRepository<Superhero, String> {
}
