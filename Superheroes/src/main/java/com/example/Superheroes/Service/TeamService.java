package com.example.Superheroes.Service;

import com.example.Superheroes.Excepcion.ValidationException;
import com.example.Superheroes.Model.Team;
import com.example.Superheroes.Repo.TeamJpaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final TeamJpaRepo teamJpaRepo;

    public void create(Team team) {
        validateTeam(team);
        teamJpaRepo.save(team);
    }

    public Team update(Team team, String id) {
        validateTeam(team);
        return teamJpaRepo.save(team.toBuilder().id(id).build());
    }

    public List<Team> findAll() {
        return teamJpaRepo.findAll();
    }

    public Optional<Team> findById(String id) {
        return teamJpaRepo.findById(id);
    }
    private void validateTeam(Team team) throws ValidationException {
        if (!StringUtils.hasText(team.getName())) {
            throw new ValidationException("Nincs ilyen nevű Team");
        }
//        if (!team.getKind().equals("HERO") && !team.getKind().equals(Kind.VILLIAN)) {
//            throw new BuciException("");
//        }
//        if (!StringUtils.hasText(team.getUniverse().toString())) {
//            throw new BuciException("");
//        }
    }
}
