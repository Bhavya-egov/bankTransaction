package com.example.BankTransaction.service;

import com.example.BankTransaction.User;
import com.example.BankTransaction.UserTransaction;
import com.example.BankTransaction.repositary.BankUser;
import com.example.BankTransaction.repositary.Transaction;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
public class BankService {
    private BankUser bankUser;
    private Transaction transaction;

    public BankService(BankUser bankUser, Transaction transaction) {
        this.bankUser = bankUser;
        this.transaction = transaction;
    }
    public void saveUser(User user){
        bankUser.save(user);
    }
    public void transactMoney(String AccountNo, BigDecimal transactedAmount, char creditOrDebit) {
        User user = bankUser.findByAccountNumber(AccountNo);
        user.setAccountNo(AccountNo);
        BigDecimal currentAmount = user.getCurrentAmount();

        if (creditOrDebit == 'C') {
            currentAmount = currentAmount.add(transactedAmount);
        } else if (creditOrDebit == 'D') {
            if (transactedAmount.compareTo(currentAmount) > 0) {
                throw new IllegalArgumentException("Insufficient balance.");
            }
            currentAmount = currentAmount.subtract(transactedAmount);
        } else {
            throw new IllegalArgumentException("Invalid transaction type.");
        }

        user.setCurrentAmount(currentAmount);
        bankUser.save(user);

        UserTransaction userTransaction = new UserTransaction();
        userTransaction.setAccountNo(AccountNo);
        userTransaction.setTransactedAmount(transactedAmount);
        userTransaction.setCreditOrDebit(creditOrDebit);
        transaction.create(userTransaction);
    }
}
