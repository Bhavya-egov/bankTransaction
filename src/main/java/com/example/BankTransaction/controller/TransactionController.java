package com.example.BankTransaction.controller;

import com.example.BankTransaction.UserTransaction;
import com.example.BankTransaction.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.math.BigInteger;

@RestController
@RequestMapping("/bank")
public class TransactionController {
    @Autowired
    private BankService bankService;
    @Autowired
    public TransactionController(BankService bankService) {
        this.bankService = bankService;
    }

    @PostMapping("/trans")
    public ResponseEntity<String> TransactMoney(@RequestBody UserTransaction userTransaction){
        try{
            bankService.transactMoney(userTransaction.getAccountNo(),userTransaction.getTransactedAmount(), userTransaction.getCreditOrDebit());
            return ResponseEntity.ok("Transaction Processed Successfully");
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
