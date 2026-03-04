package com.lendingcatalog;

public class BankAccount {
    private String accountType;
    private String accountNumber;
    private String[] signers;

    public BankAccount(String accountNumber, String  accountType, String[] signers){
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.signers = signers;
    }
    public String getAccountType(){
        return accountType;
    }
    public String getAccountNumber(){return accountNumber;}
    public String[] getAccountSigners(){return signers;}



}
