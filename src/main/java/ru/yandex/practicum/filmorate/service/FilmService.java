package ru.yandex.practicum.filmorate.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.filmorate.model.Film;
import ru.yandex.practicum.filmorate.storage.film.FilmStorage;
import ru.yandex.practicum.filmorate.storage.user.UserStorage;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class FilmService {
    private final Map<Long, Film> films = new HashMap<>();
    private final UserStorage userStorage;
    private final FilmStorage filmStorage;

    public FilmService(@Qualifier("InMemoryUserStorage") UserStorage userStorage, @Qualifier("InMemoryFilmStorage") FilmStorage filmStorage) {
        this.userStorage = userStorage;
        this.filmStorage = filmStorage;
    }

    public Film createFilm(Film film) {
        log.info("Добавление нового фильма.");
        return filmStorage.createFilm(film);
    }

    public Film updateFilm(Film newFilm) {
        log.info("Обновление фильма.");
        return filmStorage.updateFilm(newFilm);
    }

    public Collection<Film> findAllFilm() {
        log.info("Вывод список фильмов.");
        return filmStorage.findAllFilm();
    }
}