package com.assignment.gamecrud.controller;

import com.assignment.gamecrud.dto.GameDTO;
import com.assignment.gamecrud.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class GameController {

    @Autowired
    private GameService gameService;

    @RequestMapping(value = "/")
    public String home() {
        return "home";
    }

    @PostMapping(value = "/createGame", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public ResponseEntity<GameDTO> createSingleGame(@RequestBody GameDTO newGame) {
        return new ResponseEntity<>(gameService.createGame(newGame), HttpStatus.CREATED);
    }

    @GetMapping(value = "/getGame")
    @ResponseBody
    public ResponseEntity<GameDTO> getGameByID(@RequestParam long id) {
        return ResponseEntity.ok(gameService.readGame(id));
    }

    @GetMapping(value = "/getAllGames")
    @ResponseBody
    public ResponseEntity<ArrayList<GameDTO>> getAllGames() {
        return ResponseEntity.ok(gameService.getAllGames());
    }

    @PutMapping(value = "/updateGame")
    @ResponseBody
    public ResponseEntity<GameDTO> updateGame(@RequestParam long id, @RequestBody GameDTO game) {
        return ResponseEntity.ok(gameService.updateGame(id,game));
    }

    @DeleteMapping(value = "/deleteGame")
    @ResponseBody
    public ResponseEntity<String> deleteGame(@RequestParam long id) {
        gameService.deleteGame(id);
        return new ResponseEntity<>("Game deleted successfully", HttpStatus.OK);
    }

}
