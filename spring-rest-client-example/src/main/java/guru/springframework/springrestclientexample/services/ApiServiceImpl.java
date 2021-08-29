package guru.springframework.springrestclientexample.services;

import guru.springframework.api.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class ApiServiceImpl implements ApiService {

    private final RestTemplate restTemplate;
    private final String api_url;
    private final String USERS_SERVICE = "users";

    public ApiServiceImpl(RestTemplate restTemplate, @Value("${api_url}") String api_url) {
        this.restTemplate = restTemplate;
        this.api_url = api_url;
    }

    @Override
    public List<User> getUsers() {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder
                .fromUriString(api_url)
                .pathSegment(USERS_SERVICE);

        User[] users = restTemplate.getForObject(uriBuilder.toUriString(), User[].class);

        return Arrays.asList(users);
    }
}
