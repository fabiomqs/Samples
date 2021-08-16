package guru.springframework.sfgdi.repositories;

public class EnglishGreetingRepositoryimpl implements EnglishGreetingRepository {

    @Override
    public String getGreeting() {
        return "Hello World - EN";
    }
}
