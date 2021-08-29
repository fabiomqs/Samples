package guru.springframework.springrestclientexample.service;

import guru.springframework.api.domain.User;

import java.util.List;

public interface ApiService {

    public List<User> getUsers();
}
