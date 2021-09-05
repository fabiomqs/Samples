package guru.springframework.sfgdi.services;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class PrototypeBean {
    private String name = "nome";
    public PrototypeBean() {
        System.out.println("Creating a Prototype Bean!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    public String getMyScope() {
        return "I'm a Prototype and my name is " + this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
