package Wallet;

import java.util.ArrayList;

public class Wallet {
    private double balance; //số dư hiện
    private String ownerName;
    private ArrayList<String> transactionHistory; //Lưu về các hoạt động

    //Constructor


    public Wallet(String ownerName,double initialBalance) {
        if(initialBalance < 0){
            throw new IllegalArgumentException("Not suitable!");
        }

        this.ownerName=ownerName;
        this.balance=initialBalance;
        this.transactionHistory=new ArrayList<>();

        transactionHistory.add(String.format("Khoi tao: %.1f",balance));

    }

    public double getBalance() {
        return balance;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public ArrayList<String> getTransactionHistory() {
        return transactionHistory;
    }

    public void deposit(double amount){
        if(amount <= 0){
            throw new IllegalArgumentException("So du phai lon hon 0");
        }
        balance += amount;
        transactionHistory.add(String.format("Deposited: +%.1f", amount));
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            transactionHistory.add(String.format("Failed withdrawal: %.1f", amount));
            throw new IllegalArgumentException("So tien rut phai > 0!");
        }

        if (amount > balance) {
            transactionHistory.add(String.format("Failed withdrawal: %.1f", amount));
            throw new IllegalArgumentException("Khong du so du!");
        }

        balance -= amount;
        transactionHistory.add(String.format("Withdrew: -%.1f", amount));

    }
}
