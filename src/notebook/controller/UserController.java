package notebook.controller;

import notebook.model.User;
import notebook.model.repository.GBRepository;

import java.util.List;
import java.util.Objects;

public class UserController {
    private final GBRepository repository;

    public UserController(GBRepository repository) {
        this.repository = repository;
    }

    public void saveUser(User user) {
        repository.create(user);
    }

    public String prompt(String message){
        return repository.prompt(message);
    }

    public User createUser(){
        return repository.createUser();
    }
    public boolean deleteUser(long userId){
        return repository.delete(userId);
    }
    public User readUser(Long userId) throws Exception {
        List<User> users = repository.findAll();
        for (User user : users) {
            if (Objects.equals(user.getId(), userId)) {
                return user;
            }
        }

        throw new RuntimeException("User not found");
    }

    public void updateUser(String userId, User update) {
        update.setId(Long.parseLong(userId));
        repository.update(Long.parseLong(userId), update);
    }
    public List<User> readAll() {
        return repository.findAll();
    }

    public User findById(long userId){
        return repository.findById(userId);
    }
}
