package com.assignment.gamecrud.utility;

import com.assignment.gamecrud.dto.GameDTO;
import com.assignment.gamecrud.entity.Game;

public class Converter {

    public static Game toGame(GameDTO game) {
        return new Game().builder()
                .url(game.getUrl())
                .author(game.getAuthor())
                .name(game.getName())
                .publishedDate(game.getPublishedDate())
                .build();
    }

    public static GameDTO toGameDTO(Game game) {
        return new GameDTO().builder()
                .url(game.getUrl())
                .author(game.getAuthor())
                .name(game.getName())
                .publishedDate(game.getPublishedDate())
                .build();
    }

}
