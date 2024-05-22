package com.ltudjv.btbuoi2.services;

import com.ltudjv.btbuoi2.entities.BankAccount;
import com.ltudjv.btbuoi2.repositories.BankAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {
    private final BankAccountRepository repository;
    @Override
    public List<BankAccount> listAccounts() {
        return repository.findAll();
    }
}
