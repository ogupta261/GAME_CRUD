package com.assignment.gamecrud.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
@ToString
@Entity
@Table(name = "game", uniqueConstraints = { @UniqueConstraint(name = "UniqueNameAndAuthor", columnNames = { "name","author" }) })
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NonNull
    @Column(length = 50)
    private String name;

    @NonNull
    @Column(length = 50)
    private String author;

    @Nullable
    private String url;

    @NonNull
    private LocalDate publishedDate;

}
