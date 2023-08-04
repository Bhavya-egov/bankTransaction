package com.example.BankTransaction.repositary;

import com.example.BankTransaction.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.math.BigInteger;
import java.util.Random;
@Repository
public class BankUser{
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public void save(User user) {
        String accountNumber = generateAccountNumber();
        user.setAccountNo(String.valueOf(accountNumber));

        jdbcTemplate.update("INSERT INTO bankUser (AccountNo, name, mobileNo, address, currentAmount) VALUES (?, ?, ?, ?, ?)",
                user.getAccountNo(), user.getName(), user.getMobileNo(), user.getAddress(), user.getCurrentAmount());
    }

//    private Long generateAccountNumber() {
//        Random random = new Random(10);//length of 10
//        long accountNumber = (long) (Math.pow(10, 10) + random.nextInt((int) Math.pow(10, 10)));
//        return accountNumber;
//
//    }
    private String generateAccountNumber() {
        Random random = new Random();
        int randomNumber = random.nextInt(900000000) + 100000000; // Generate a random 9-digit number
        int randomDigitFirst = random.nextInt(9) + 1; // Generate a random non-zero digit
        int randomDigitSecond=random.nextInt(9)+1; // Generate a random non-zero digit
        return randomDigitFirst+""+randomDigitSecond+"" + randomNumber;
    }

    public User findByAccountNumber(String AccountNo) {
        //System.out.println(AccountNo+" aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        return jdbcTemplate.queryForObject("SELECT * FROM bankUser WHERE AccountNo = ?",
                new Object[]{AccountNo}, (rs, rowNum) -> {
                    User user= new User();
                    user.setAccountNo(rs.getString("AccountNo"));
                    user.setName(rs.getString("name"));
                    user.setMobileNo(rs.getString("mobileNo"));
                    user.setAddress(rs.getString("address"));
                    user.setCurrentAmount(rs.getBigDecimal("currentAmount"));
                    return user;
                });
    }
}
