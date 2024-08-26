package ru.yandex.practicum.filmorate.user.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;

@Data
public class User {

    private Long id;
    @NonNull
    @Email(message = "Адрес электронной почты введен некорректно")
    private String email;
    @NotEmpty(message = "Логин не может быть пустым")
    @Pattern(regexp = "^\\S+$")
    private String login;
    private String name;
    @NonNull
    @PastOrPresent(message = "День рождения не может быть в будущем")
    private LocalDate birthday;
}