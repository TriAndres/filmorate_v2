package ru.yandex.practicum.filmorate.film.storege;

import ru.yandex.practicum.filmorate.film.model.Film;

import java.util.Collection;
import java.util.List;

public interface FilmStorage {
    Collection<Film> getFilms();

    Film create(Film film);

    Film update(Film newFilm);

    Film findFilmById(long id);

    void addLike(long filmId, long userId);

    void deleteLike(long filmId, long userId);

    void deleteFilm(long filmId);

    List<Film> getRecommendations(long userId);
}
