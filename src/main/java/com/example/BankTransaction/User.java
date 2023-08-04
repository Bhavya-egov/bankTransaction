package com.example.BankTransaction;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;

public class User {
    private String AccountNo;
    private String name,address,mobileNo;
    private BigDecimal currentAmount;

    public String getAccountNo() {
        return AccountNo;
    }

    public void setAccountNo(String account_No) {
        AccountNo = account_No;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobile_no) {
        this.mobileNo = mobile_no;
    }

    public BigDecimal getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(BigDecimal currentAmount) {
        this.currentAmount = currentAmount;
    }

    public User() {
    }

    public User(String account_No, String name, String address, String mobileNo, BigDecimal currentAmount) {
        AccountNo = account_No;
        this.name = name;
        this.address = address;
        this.mobileNo = mobileNo;
        this.currentAmount = currentAmount;
    }
}
