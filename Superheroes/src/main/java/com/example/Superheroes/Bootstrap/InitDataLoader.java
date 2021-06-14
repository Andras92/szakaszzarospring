package com.example.Superheroes.Bootstrap;


import com.example.Superheroes.Model.Superhero;
import com.example.Superheroes.Model.Team;
import com.example.Superheroes.Repo.SuperheroJpaRepo;
import com.example.Superheroes.Repo.TeamJpaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


//Valamiért nem eszi emg a Faker-t pedig pom-ba beleraktam , és Maven frissítést is csináltam, maven package-et is ...
//--------------------------------------------------------------------------------------------

//@Component
//@RequiredArgsConstructor
//public class InitDataLoader implements CommandLineRunner {
//    private final SuperheroJpaRepo superheroJpaRepo;
//    private final TeamJpaRepo teamJpaRepo;
//
//    @Bean
//    public Faker faker() {
//        return new Faker(Locale.forLanguageTag("hu-HU"));
//    }
//
//    @Override
//    @Transactional
//    public void run(String... args) throws Exception {
//        saveTeam();
//        List<Team> actorList = teamJpaRepo.findAll();
//        saveTeam(teamList);
//        List<Superhero> movieList = superheroJpaRepo.findAll();
//        saveSuperhero(superheroList);
//    }
//
//    @Transactional
//    private void saveTeam(){
//        List<Team> teamList = teamJpaRepo.saveAll(newTeams());
//    }
//
//    @Transactional
//    private void saveSuperhero(List<Superhero> superheroList) {
//        List<Superhero> superheroList = superheroJpaRepo.saveAll(newSuperhero(superheroList));
//    }
//
//    private List<Team> newTeams() {
//        return IntStream.range(0, 2)
//                .mapToObj(value -> Team.builder()
//                        .id(UUID.randomUUID().toString())
//                        .name(faker().leagueOfLegends().champion())
//                        .build()).collect(Collectors.toList());
//    }
//    private List<Superhero> newSuperhero(List<Superhero> superheroList){
//        return IntStream.range(0,2)
//                .mapToObj(value -> Superhero.builder()
//                        .id(UUID.randomUUID().toString())
//                        .name(faker().leagueOfLegends().champion())
//                        .build()).collect(Collectors.toList());
//    }
//}
