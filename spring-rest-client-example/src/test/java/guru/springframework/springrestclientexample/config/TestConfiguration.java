package guru.springframework.springrestclientexample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.web.client.RestTemplateBuilder;

@Configuration
public class TestConfiguration {

    @Bean
    public RestTemplateBuilder restTemplateBuilder() {
        // Need to provide a rest template builder because
        // @RestTemplateAutoConfiguration does not work with webflux
        return new RestTemplateBuilder();
    }
}
