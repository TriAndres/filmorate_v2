package ru.yandex.practicum.filmorate.user.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class User {

    private Long id;
    private final String email;
    private final String login;
    private final String name;
    private final LocalDate birthday;
}