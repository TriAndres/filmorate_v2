package ru.yandex.practicum.filmorate.film.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.film.model.Film;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Validated
@Slf4j
@RestController
@RequestMapping("films")
public class FilmController {
    private final Map<Long, Film> films = new HashMap<>();

    @PostMapping
    public Film create(@Valid @RequestBody Film film) {
        return film;
    }

    @PutMapping
    public Film update(@Valid @RequestBody Film film) {
        return film;
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