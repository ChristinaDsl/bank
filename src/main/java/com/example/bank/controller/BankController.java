package com.example.bank.controller;

import com.example.bank.model.Transaction;
import com.example.bank.model.Account;
import com.example.bank.model.persistence.BankRepository;
import com.example.bank.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankController {

    private final BankRepository repository;
    private final BankService service;

    @Autowired
    public BankController(BankRepository repository, BankService service){
        this.repository = repository;
        this.service = service;
    }

    @GetMapping("accounts")
    public List<Account> all(){
        return repository.findAll();
    }

    @GetMapping("/transaction/{id1}/{id2}/{amount}")
    public void doTransaction(@PathVariable long id1, @PathVariable long id2, @PathVariable Long amount){
        Transaction transaction = new Transaction(id1, id2, amount, "EUR");
        service.doTransaction(transaction);
    }
}
