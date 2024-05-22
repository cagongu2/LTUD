package com.ltudjv.btbuoi2.controller;

import com.ltudjv.btbuoi2.entities.BankAccount;
import com.ltudjv.btbuoi2.repositories.BankAccountRepository;
import com.ltudjv.btbuoi2.services.BankAccountService;
import com.ltudjv.btbuoi2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;


    @Autowired
    private BankAccountService bankAccountService;

    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "user-list";
    }

    @GetMapping("/accounts")
    public String listAccounts(Model model) {
        List<BankAccount> accounts = bankAccountService.listAccounts();
        model.addAttribute("accounts", accounts);
        return "account-list";
    }
}
