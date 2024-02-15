package com.example.bank.model;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "source_account_id")
    private long sourceAccountId;

    @Column(name = "target_account_id")
    private long targetAccountId;

    @Column(name = "amount")
    private double amount;

    @Column(name = "currency")
    private String currency;

    public Transaction(long sourceAccountId, long targetAccountId, double amount, String currency) {
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.amount = amount;
        this.currency = currency;
    }

    public Long getId() {
        return id;
    }

    public Long getSourceAccountId() {
        return sourceAccountId;
    }

    public Long getTargetAccountId() {
        return targetAccountId;
    }

    public double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSourceAccountId(Long sourceAccountId) {
        this.sourceAccountId = sourceAccountId;
    }

    public void setTargetAccountId(Long targetAccountId) {
        this.targetAccountId = targetAccountId;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}
