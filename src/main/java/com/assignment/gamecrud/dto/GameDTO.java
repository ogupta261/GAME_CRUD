package com.assignment.gamecrud.dto;

import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GameDTO {

    private String name;

    private String author;

    private String url;

    private LocalDate publishedDate;

}
