/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingaccount;

import java.util.ArrayList;

/**
 *
 * @author Sher Khan
 */
public abstract class BankingAccount {

    private String accountNumber;
    private String accountHolder;
    private String openDate;
    private String SSN; // social security number 
    private int accountHolderID = 100; // intialized it 100\ 
    private ArrayList<String> history;
    private double bankFees;
    private double balance; //bc we access through othher classes inherited
    //We can use getter method for this
    //constructor 
    /**
     *
     * @param accountNumber
     * @param accountHolder
     * @param openDate
     * @param SSN
     * @param accountHolderID
     * @param history
     * @param bankFees
     * @param balance
     */
    public BankingAccount(String accountNumber, String accountHolder, String openDate, String SSN, int accountHolderID, ArrayList<String> history,
            double bankFees, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.openDate = openDate;
        this.SSN = SSN;
        this.accountHolderID += this.accountHolderID++;
        this.history = history;
        this.bankFees = bankFees;
        this.balance = balance;
    }

    //Withdrawl
    /**
     *
     * @param amount
     * @return
     */
    public boolean withdrawl(double amount) {
        if (amount > 0 && balance >= amount) {
            balance = balance - amount;
            return true;
        } else {
            return false;
        }
    }

    //Deposit
    /**
     *
     * @param amount
     */
    public void deposit(double amount) {
        if (amount >= 0) {
            balance = balance + amount;
        }

    }

    // Transfer between account
    //Send money from this account to another account
    /**
     *
     * @param reciever
     * @param amount
     */
    public void transfer(BankingAccount reciever, double amount) {
        this.withdrawl(amount);
        reciever.deposit(amount);

    }

    //calculates fees with balance
    /**
     *
     */
    public void calculateBalanceWithFees() {
        balance -= this.bankFees;

    }

    //SETTERS
    // accountnumber = ID + RANDOM + FIRST 2 DIGIT OF SOCIAL SECURITY NUMBER
    public void setAccountNumber() {
        int random = (int) Math.random() * 100;
        accountNumber = accountHolderID + " " + random + SSN.substring(0, 2);
    }

    // GETTERS 
    public String getAccountNumber() {
        return this.accountNumber;
    }

    public String getAccountHolder() {
        return this.accountHolder;
    }

    public String getopenDate() {
        return this.openDate;
    }

    public String getSSN() {
        return this.SSN;
    }

    public int getaccountHolderID() {
        return this.accountHolderID;
    }

    public ArrayList gethistory() {
        return this.history;
    }

    public double getbankFees() {
        return this.bankFees;
    }

    public double getBalance() {
        this.calculateBalanceWithFees();
        return this.balance;
    }
    
    public void setBalance(double amount) {
        this.balance = amount;
    }
}
