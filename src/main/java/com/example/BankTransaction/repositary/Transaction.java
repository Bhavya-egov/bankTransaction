package com.example.BankTransaction.repositary;

import com.example.BankTransaction.UserTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
@Repository
public class Transaction {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void create(UserTransaction userTransaction){
        jdbcTemplate.update("INSERT INTO transaction(accountNo, transactedAmount, creditOrDebit) VALUES (?, ?, ?)",
                userTransaction.getAccountNo(),userTransaction.getTransactedAmount(),userTransaction.getCreditOrDebit());    }


}
