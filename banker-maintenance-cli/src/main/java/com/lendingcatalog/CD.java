package com.lendingcatalog;

public class CD extends BankAccount{

    Double interestRate;
    int term;
    String maturity;

    public CD(String accountNumber, String accountType, Double interestRate, Integer term, String maturity, String[] signers) {
        super(accountType, accountNumber, signers);
        this.interestRate = interestRate;
        this.term = term;
        this.maturity = maturity;
    }

    public String getMaturity(){
        return maturity;
    }
    public Double getInterestRate(){
        return interestRate;
    }
    public int getTerm(){
        return term;
    }
}
