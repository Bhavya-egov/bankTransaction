package com.example.BankTransaction;

import java.math.BigDecimal;

public class UserTransaction {
    private long id;
    private String accountNo;
    private BigDecimal transactedAmount;
    private char creditOrDebit;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccountNo() {
        return this.accountNo;
    }

    public void setAccountNo(String AccountNo) {
        this.accountNo = AccountNo;
    }

    public BigDecimal getTransactedAmount() {
        return transactedAmount;
    }

    public void setTransactedAmount(BigDecimal transactedAmount) {
        this.transactedAmount = transactedAmount;
    }

    public char getCreditOrDebit() {
        return creditOrDebit;
    }

    public void setCreditOrDebit(char creditOrDebit) {
        this.creditOrDebit = creditOrDebit;
    }

    public UserTransaction() {
    }

    public UserTransaction(long id, String account_No, BigDecimal transactedAmount, char creditOrDebit) {
        this.id = id;
        this.accountNo = account_No;
        this.transactedAmount = transactedAmount;
        this.creditOrDebit = creditOrDebit;
    }
}
