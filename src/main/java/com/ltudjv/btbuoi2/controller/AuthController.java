package com.ltudjv.btbuoi2.controller;

import com.ltudjv.btbuoi2.services.AuthService;
import com.ltudjv.btbuoi2.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;


@Controller
@AllArgsConstructor
public class AuthController {
    @Autowired
    private AuthService authService;

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "auth/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user, Model model) {
        if (authService.Login(user.getUsername(), user.getPassword())) {
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "auth/login";
        }
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        List<String> listProfession = Arrays.asList("Developer", "Tester", "Architect");
        model.addAttribute("listProfession", listProfession);
        return "auth/register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user, Model model) {
        if (authService.Register(user)) {
            return "redirect:/login";
        } else {
            model.addAttribute("error", "Username already exists");
            return "auth/register";
        }
    }

    @GetMapping("/home")
    public String home() {
        return "home/index";
    }
}
