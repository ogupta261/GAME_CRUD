package com.assignment.gamecrud.utility;

import com.assignment.gamecrud.dto.GameDTO;
import com.assignment.gamecrud.exception.CustomException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class Validation {
    private static Logger log = LoggerFactory.getLogger(Validation.class);

    private static final String NAME_EMPTY = "Please fill the Name.";
    private static final String NAME_INVALID = "Book Name should be only alphabets and spaces between 2 to 50 characters.";
    private static final String AUTHOR_EMPTY = "Please fill the Author.";
    private static final String AUTHOR_INVALID = "Author Name should be only alphabets and spaces between 2 to 50 characters.";
    private static final String URL_INVALID = "URL should be a link starting with http OR https";
    private static final String DATE_EMPTY = "Please fill the Date";
    private static final String ID_INVALID = "ID should be more than 1.";

    public static final String GAME_NOT_FOUND = "No Game found with this ID";

    public static void validateID(long id) {
        if(id < 1) {
            log.error(ID_INVALID, CustomException.class);
            throw new CustomException(ID_INVALID);
        }
    }
    public static void validateGame(GameDTO game) {
        validateName(game.getName());
        validateAuthor(game.getAuthor());
        validateUrl(game.getUrl());
        validateDate(game.getPublishedDate());
    }

    public static void validateName(String name) {
        if(name == null || name.length()==0) {
            log.error(NAME_EMPTY, CustomException.class);
            throw new CustomException(NAME_EMPTY);
        }
        if(!name.matches("^[a-zA-Z0-9\\s]{2,50}$")){
            log.error(NAME_INVALID, CustomException.class);
            throw new CustomException(NAME_INVALID);
        }

    }

    public static void validateAuthor(String author) {
        if(author == null || author.length()==0) {
            log.error(AUTHOR_EMPTY, CustomException.class);
            throw new CustomException(AUTHOR_EMPTY);
        }
        if(!author.matches("^[a-zA-Z\\s]{2,50}$")){
            log.error(AUTHOR_INVALID, CustomException.class);
            throw new CustomException(AUTHOR_INVALID);
        }
    }

    public static void validateUrl(String url) {
        if(url!=null && url.length()>0 && !url.matches("^(http|https)://([a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(:[0-9]+)?(/.*)?)?$")) {
            log.error(URL_INVALID, CustomException.class);
            throw new CustomException(URL_INVALID);
        }
    }

    public static void validateDate(LocalDate date) {
        if(date == null) {
            log.error(DATE_EMPTY, CustomException.class);
            throw new CustomException(DATE_EMPTY);
        }
    }
}
