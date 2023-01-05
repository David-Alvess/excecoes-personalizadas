package models.entities;

import models.exceptions.CustomExceptions;

public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account(){
    }
    public Account(Integer number, String holder, Double balance, Double withdrawLimit) throws CustomExceptions {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }
    public Integer getNumber() {
        return number;
    }
    public String getHolder() {
        return holder;
    }

    public Double getBalance() {
        return balance;
    }
    public Double getWithdrawLimit() {
        return withdrawLimit;
    }
    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }
    public void deposit(double value){
        this.balance += value;
    }
    public void withdraw(double value) throws CustomExceptions {
        if (balance <= 0 || value > balance){
            throw new CustomExceptions("Not enough balance");
        }
        if (value > withdrawLimit){
            throw new CustomExceptions("The amounts exceeds withdraw limits");
        }
        this.balance -= value;
    }

    @Override
    public String toString() {
        return balance.toString();
    }
}
