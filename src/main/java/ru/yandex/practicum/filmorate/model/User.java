package ru.yandex.practicum.filmorate.model;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
public class User {
    private Long id;
    @Email(message = "электронная почта не может быть пустой и должна содержать символ @")
    private String email;
    @NotEmpty(message = "логин не может быть пустым и содержать пробелы")
    private String login;
    private String name;
    @PastOrPresent(message = "дата рождения не может быть в будущем.")
    private LocalDate birthday;
    private final Set<Long> friends = new HashSet<>();
}