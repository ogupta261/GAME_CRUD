package com.assignment.gamecrud.service;

import com.assignment.gamecrud.dto.GameDTO;
import com.assignment.gamecrud.entity.Game;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

public interface GameService {

    GameDTO createGame(GameDTO game);

    GameDTO readGame(long id);

    ArrayList<GameDTO> getAllGames();

    GameDTO updateGame(long id, GameDTO game);

    void deleteGame(long id);

}
