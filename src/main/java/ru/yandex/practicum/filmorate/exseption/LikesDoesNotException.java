package ru.yandex.practicum.filmorate.exseption;

public class LikesDoesNotException extends RuntimeException {
    public LikesDoesNotException(String message) {
        super(message);
    }
}