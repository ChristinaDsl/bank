package com.example.bank;

import com.example.bank.model.Account;
import com.example.bank.model.persistence.BankRepository;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.slf4j.Logger;

@Configuration
public class BankDBLoad {

    private static final Logger logger = LoggerFactory.getLogger(BankDBLoad.class);

    @Bean
    CommandLineRunner initDatabase(BankRepository repository) {

        logger.info("Initializing database...");

        return args -> {
            try {
                Account account1 = new Account(1, 500, "GBP", "21.01.1999");
                Account account2 = new Account(2, 230, "GBP", "20.01.1997");

                logger.info("Preloading account: " + repository.save(account1).getId());
                logger.info("Preloading account: " + repository.save(account2).getId());
            } catch (Exception e) {
                logger.error("Error preloading data into the database", e);
            }
        };

    }

}
