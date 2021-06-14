package com.example.Superheroes.Repo;

import com.example.Superheroes.Model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamJpaRepo  extends JpaRepository<Team,String> {
}
