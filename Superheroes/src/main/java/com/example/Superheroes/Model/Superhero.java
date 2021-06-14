package com.example.Superheroes.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "superhero")
public class Superhero {
 @Id
// @GeneratedValue(generator = "UUID")
// @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
 private String id;
 private String name;
 private Universe universe;
 @ManyToOne
 private Team team;
 @JsonIgnore
 private boolean hero;
}
