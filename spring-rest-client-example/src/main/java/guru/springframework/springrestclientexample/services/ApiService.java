package guru.springframework.springrestclientexample.services;

import guru.springframework.api.domain.User;

import java.util.List;

public interface ApiService {

    public List<User> getUsers();
}
