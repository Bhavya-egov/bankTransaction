package com.example.BankTransaction.controller;

import com.example.BankTransaction.User;
import com.example.BankTransaction.UserTransaction;
import com.example.BankTransaction.repositary.BankUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RequestMapping("/bank")
@RestController
public class BankController {
    @Autowired
    private BankUser bankUser;

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void createTables(){

        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS bankUser (AccountNo BIGINT PRIMARY KEY, Name VARCHAR(255), Address VARCHAR(255), mobileNo VARCHAR(20), CurrentAmount DECIMAL(10,2))");

        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS transaction(id SERIAL PRIMARY KEY, AccountNo BIGINT, transactedAmount DECIMAL(10,2), creditOrDebit CHAR(1), FOREIGN KEY (AccountNo) REFERENCES bankUser(AccountNo))");

}
    @PostMapping("/user")
    public ResponseEntity<String> saveBankUser(@RequestBody User user) {
        //System.out.println(user+" uuuuuuuuuuuuuuuuuuuuuuuuu");
        try{
            bankUser.save(user);
            return ResponseEntity.ok("Bank user saved successfully.");

        }catch(Exception e){
            String errorMessage = "Failed to create account: "+ e;
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
