package com.ltudjv.btbuoi2.repositories;

import com.ltudjv.btbuoi2.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BankAccountRepository extends JpaRepository<BankAccount, UUID> {
}
