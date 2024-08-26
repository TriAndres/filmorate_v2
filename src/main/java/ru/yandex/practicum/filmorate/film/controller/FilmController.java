package ru.yandex.practicum.filmorate.film.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.exceptions.FilmNotFondException;
import ru.yandex.practicum.filmorate.film.model.Film;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Validated
@Slf4j
@RestController
@RequestMapping("/films")
public class FilmController {

    private final Map<Long, Film> films = new HashMap<>();

    @PostMapping
    public Film create(@Valid @RequestBody Film film) {
        film.setId(getNextId());
        films.put(film.getId(), film);
        log.info("Добавлен новый фильм.");
        return film;
    }

    @PutMapping
    public Film update(@Valid @RequestBody Film newFilm) {
        if (films.containsKey(newFilm.getId())) {
            Film oldFilm = films.get(newFilm.getId());
            oldFilm.setName(newFilm.getName());
            oldFilm.setDescription(newFilm.getDescription());
            oldFilm.setReleaseDate(newFilm.getReleaseDate());
            oldFilm.setDuration(newFilm.getDuration());
            log.info("Обнавлё фильм с id {}",oldFilm.getId());
            return oldFilm;
        }
        log.error("Фильм с id {} не найден",newFilm.getId());
        throw new FilmNotFondException();
    }

    @GetMapping
    public Collection<Film> getUsers() {
        return films.values();
    }

    public Long getNextId() {
        long currentMaxId = films.keySet()
                .stream()
                .mapToLong(id -> id)
                .max()
                .orElse(0);
        return ++currentMaxId;
    }
}