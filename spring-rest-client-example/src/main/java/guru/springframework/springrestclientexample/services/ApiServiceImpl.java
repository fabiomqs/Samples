package guru.springframework.springrestclientexample.services;

import guru.springframework.api.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {

    private RestTemplate restTemplate;

    public ApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<User> getUsers() {
        User[] users = restTemplate.getForObject("https://fakestoreapi.com/users", User[].class);

        return Arrays.asList(users);
    }
}
