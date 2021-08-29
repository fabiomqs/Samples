package guru.springframework.springrestclientexample.controllers;

import guru.springframework.springrestclientexample.services.ApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class UserController {

    private final ApiService apiService;

    public UserController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping({"", "/"})
    public String getAllUsers(Model model) {
        model.addAttribute("users", apiService.getUsers());
        return "userlist";
    }

}
