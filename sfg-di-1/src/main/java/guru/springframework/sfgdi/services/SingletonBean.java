package guru.springframework.sfgdi.services;

import org.springframework.stereotype.Component;

@Component
public class SingletonBean {

    private String name = "nome";

    public SingletonBean() {
        System.out.println("Creating a Singleton Bean!!!");
    }

    public String getMyScope() {
        return "I'm a Singleton and my name is " + this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
