package ru.yandex.practicum.filmorate.exseption;

public class FilmDoesNotExistException extends RuntimeException {
    public FilmDoesNotExistException(String message) {
        super(message);
    }
}