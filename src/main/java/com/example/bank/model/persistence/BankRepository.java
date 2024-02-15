package com.example.bank.model.persistence;

import com.example.bank.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface BankRepository extends JpaRepository<Account, Long> {

    Optional<Account> findById(Long id);

    Account findByid(Long id);
}
