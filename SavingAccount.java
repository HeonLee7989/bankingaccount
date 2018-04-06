/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingaccount;

import java.util.ArrayList;

public class SavingAccount extends BankingAccount implements IInterest {

    private int interest;

    public SavingAccount(String accountNumber, String accountHolder, String openDate, String SSN, int accountHolderID, ArrayList<String> history, double bankFees, double balance, int interest) {
        super(accountNumber, accountHolder, openDate, SSN, accountHolderID, history, bankFees, balance);

        this.interest = interest;
    }

    
    public double getbalance() {
        this.calculateInterestWithBalance();
        return this.getBalance();
    }

    public void calculateInterestWithBalance() {
        this.setBalance(this.getBalance() * interest);

    }

    @Override
    public void calculateInterestRate() {
        
    }

}
