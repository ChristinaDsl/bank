package com.example.bank.service;

import com.example.bank.model.Account;
import com.example.bank.model.Transaction;
import com.example.bank.model.persistence.BankRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService {

    private final BankRepository repository;

    private static final Logger logger = LoggerFactory.getLogger(Transaction.class);


    @Autowired
    public BankService(BankRepository repository){
        this.repository = repository;
    }

    public void doTransaction(Transaction transaction){
        Account sourceAccount = repository.findByid(transaction.getSourceAccountId());
        logger.info("Source account balance: "+sourceAccount.getBalance());

        Account targetAccount = repository.findByid(transaction.getTargetAccountId());
        logger.info("Target account balance: "+sourceAccount.getBalance());

        double sourceAccountBalance = sourceAccount.getBalance() - transaction.getAmount();
        sourceAccount.setBalance(sourceAccountBalance);

        double targetAccountBalance = targetAccount.getBalance() + transaction.getAmount();
        targetAccount.setBalance(targetAccountBalance);

        repository.save(sourceAccount);
        Account sourceAccount1 = repository.findByid(transaction.getSourceAccountId());
        logger.info("Source account new balance: "+sourceAccount1.getBalance());

        repository.save(targetAccount);
        Account targetAccount1 = repository.findByid(transaction.getTargetAccountId());
        logger.info("Target account new balance: "+targetAccount1.getBalance());

    }
}
