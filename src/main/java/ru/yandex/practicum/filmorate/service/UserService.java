package ru.yandex.practicum.filmorate.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.filmorate.model.User;
import ru.yandex.practicum.filmorate.storage.film.FilmStorage;
import ru.yandex.practicum.filmorate.storage.user.UserStorage;

import java.util.Collection;

@Slf4j
@Service
public class UserService {
    private final UserStorage userStorage;
    private final FilmStorage filmStorage;

    public UserService(@Qualifier("inMemoryUserStorage") UserStorage userStorage, @Qualifier("inMemoryFilmStorage") FilmStorage filmStorage) {
        this.userStorage = userStorage;
        this.filmStorage = filmStorage;
    }

    public User createUser(User user) {
        log.info("Добавление нового пользователя.");
        return userStorage.createUser(user);
    }

    public User updateUser(User newUser) {
        log.info("Обновление пользователя.");
        return userStorage.updateUser(newUser);
    }

    public Collection<User> findAllUser() {
        log.info("Вывод список пользователей.");
        return userStorage.findAllUser();
    }
}