package com.lendingcatalog;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SavingsAccountTest {
    @Test
    public void correctAccountNumber(){
        String[] signers = {"John Doe", "Jane Doe"};
        SavingsAccount account = new SavingsAccount("123456789", "SAVINGS", 0.01, signers);
        assertEquals("123456789", account.getAccountType());
    }
    @Test
    public void correctAccountType(){
        String[] signers = {"John Doe", "Jane Doe"};
        SavingsAccount account = new SavingsAccount("123456789", "SAVINGS", 0.01, signers);
        assertEquals("123456789", account.getAccountType());
    }
    @Test
    public void correctAccountSigners(){
        String[] signers = {"John Doe", "Jane Doe"};
        SavingsAccount account = new SavingsAccount("123456789", "SAVINGS", 0.01, signers);
        assertEquals("123456789", account.getAccountType());
    }
    @Test
    public void correctInterestRate(){
        String[] signers = {"John Doe", "Jane Doe"};
        SavingsAccount account = new SavingsAccount("123456789", "SAVINGS", 0.01, signers);
        assertEquals(0.01, account.getInterestRate());
    }

}
