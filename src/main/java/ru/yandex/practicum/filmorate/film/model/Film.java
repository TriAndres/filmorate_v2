package ru.yandex.practicum.filmorate.film.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.validator.constraints.Length;
import ru.yandex.practicum.filmorate.validator.ReleaseDateValidation;

import java.time.LocalDate;

@Data
public class Film {

    private Long id;
    @NotEmpty(message = "название не может быть пустым")
    private String name;
    @NonNull
    @Length(max = 200, message = "максимальная длина описания — 200 символов")
    private String description;
    @NonNull
    @ReleaseDateValidation
    private LocalDate releaseDate;
    @NonNull
    @Positive(message = "продолжительность фильма должна быть положительным числом")
    private Integer duration;
}