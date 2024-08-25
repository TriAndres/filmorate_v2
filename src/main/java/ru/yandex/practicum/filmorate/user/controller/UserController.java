package ru.yandex.practicum.filmorate.user.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.user.model.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Validated
@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {
    private final Map<Long, User> users = new HashMap<>();

    @PostMapping
    public User create(@Valid @RequestBody User user) {
        return user;
    }

    @PutMapping
    public User update(@Valid@RequestBody User user) {
        return user;
    }

    @GetMapping
    public Collection<User> getUsers() {
        return users.values();
    }

    public Long getNextId() {
        long currentMaxId = users.keySet()
                .stream()
                .mapToLong(id -> id)
                .max()
                .orElse(0);
        return ++currentMaxId;
    }
}
