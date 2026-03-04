package com.lendingcatalog;

public class SavingsAccount extends BankAccount{
    Double interestRate;
    public SavingsAccount(String accountNumber, String accountType, Double interestRate, String[] signers) {
        super(accountType, accountNumber, signers);
        this.interestRate = interestRate;
    }
    public Double getInterestRate(){
        return interestRate;
    }
}
