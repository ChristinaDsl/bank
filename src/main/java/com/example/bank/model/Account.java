package com.example.bank.model;


import jakarta.persistence.*;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "balance")
    private double balance;

    @Column(name = "currency")
    private String currency;

    @Column(name = "created_at")
    private String createdAt;

    public Account(long id, double balance, String currency, String createdAt){
        this.id =  id;
        this.balance = balance;
        this.currency = currency;
        this.createdAt = createdAt;
    }

    public Account(){}

    public long getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public String getCurrency() {
        return currency;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
