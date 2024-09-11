package ru.yandex.practicum.filmorate.user.storege;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.yandex.practicum.filmorate.exceptions.UserDoesNotException;
import ru.yandex.practicum.filmorate.user.model.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class InMemoryUserStorage implements UserStorage {
    private final Map<Long, User> users = new HashMap<>();

    @Override
    public Collection<User> getUsers() {
        return users.values();
    }

    @Override
    public User create(User user) {
        user.setId(getNextId());
        if (user.getName() == null) {
            user.setName(user.getLogin());
        }
        users.put(user.getId(), user);
        log.info("Добавлен новый пользователь .");
        return user;
    }

    @Override
    public User update(User newUser) {
        if (users.containsKey(newUser.getId())) {
            User oldUser = users.get(newUser.getId());
            oldUser.setEmail(newUser.getEmail());
            oldUser.setLogin(newUser.getLogin());
            oldUser.setName(newUser.getName());
            oldUser.setBirthday(newUser.getBirthday());
            log.info("Обнавлён пользователь с id {} ", oldUser.getId());
            return newUser;
        }
        log.error("Пользователь с id {} не найден ", newUser.getId());
        throw new UserDoesNotException();
    }

    @Override
    public User findUserById(long id) {
        return null;
    }

    @Override
    public void addFriend(long userId, long friendId) {

    }

    @Override
    public void removeFromFriends(long userId, long friendId) {

    }

    @Override
    public List<User> getMutualFriends(long userId, long otherUserId) {
        return List.of();
    }

    @Override
    public List<User> getAllFriends(long userId) {
        return List.of();
    }

    @Override
    public void deleteUser(long userId) {

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
