package com.lendingcatalog;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckingAccountTest {
    @Test
    public void correctAccountNumber(){
        String[] signers = {"John Doe", "Jane Doe"};
        CheckingAccount account = new CheckingAccount("123456789", "CHECKING", signers);
        assertEquals("123456789", account.getAccountType());
    }
    @Test
    public void correctAccountType(){
        String[] signers = {"John Doe", "Jane Doe"};
        CheckingAccount account = new CheckingAccount("123456789", "CHECKING", signers);
        assertEquals("CHECKING", account.getAccountNumber());
    }
    @Test
    public void correctAccountSigners(){
        String[] signers = {"John Doe", "Jane Doe"};
        CheckingAccount account = new CheckingAccount("123456789", "CHECKING", signers);
        assertEquals(signers, account.getAccountSigners());
    }
}
