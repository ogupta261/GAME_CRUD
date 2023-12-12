package com.assignment.gamecrud.service;

import com.assignment.gamecrud.dao.GameRepo;
import com.assignment.gamecrud.dto.GameDTO;
import com.assignment.gamecrud.entity.Game;
import com.assignment.gamecrud.exception.CustomException;
import com.assignment.gamecrud.utility.Converter;
import com.assignment.gamecrud.utility.Validation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.assignment.gamecrud.utility.Validation.*;
import static com.assignment.gamecrud.utility.Converter.*;

@Service
public class GameServiceImpl implements GameService {

    private static Logger log = LoggerFactory.getLogger(Validation.class);
    @Autowired
    private GameRepo gameRepo;

    @Override
    public GameDTO createGame(GameDTO game) {
        validateGame(game);
        return toGameDTO(gameRepo.save(toGame(game)));
    }

    @Override
    public GameDTO readGame(long id) {
        validateID(id);
        Optional<Game> game = gameRepo.findById(id);
        if(game.isEmpty()) {
            log.error(GAME_NOT_FOUND, CustomException.class);
            throw new CustomException(GAME_NOT_FOUND);
        }

        return toGameDTO(game.get());
    }

    @Override
    public ArrayList<GameDTO> getAllGames() {
        return (ArrayList<GameDTO>) gameRepo.findAll().stream().map(Converter::toGameDTO).collect(Collectors.toList());
    }

    @Override
    public GameDTO updateGame(long id, GameDTO game) {
        Optional<Game> gameOptional = gameRepo.findById(id);
        if(gameOptional.isEmpty()) {
            log.error(GAME_NOT_FOUND, CustomException.class);
            throw new CustomException(GAME_NOT_FOUND);
        }
        Game updatedGame = gameOptional.get();

        if(game.getName()!=null) {
            validateName(game.getName());
            updatedGame.setName(game.getName());
        }

        if(game.getUrl()!=null) {
            validateUrl(game.getUrl());
            updatedGame.setUrl(game.getUrl());
        }

        if(game.getAuthor()!=null) {
            validateAuthor(game.getAuthor());
            updatedGame.setAuthor(game.getAuthor());
        }

        if(game.getPublishedDate()!=null) {
            validateDate(game.getPublishedDate());
            updatedGame.setPublishedDate(game.getPublishedDate());
        }

        return toGameDTO(gameRepo.save(updatedGame));
    }

    @Override
    public void deleteGame(long id) {
        validateID(id);
        Optional<Game> gameOptional = gameRepo.findById(id);
        if(gameOptional.isEmpty()) {
            log.error(GAME_NOT_FOUND, CustomException.class);
            throw new CustomException(GAME_NOT_FOUND);
        }
        gameRepo.deleteById(id);
    }
}
