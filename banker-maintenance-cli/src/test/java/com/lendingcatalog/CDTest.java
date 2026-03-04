package com.lendingcatalog;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CDTest {
    @Test
    public void correctAccountNumber(){
        String[] signers = {"John Doe", "Jane Doe"};
        CD account = new CD("123456789", "CD", 0.01, 6, "11/17/2025", signers);
        assertEquals("123456789", account.getAccountType());
    }
    @Test
    public void correctAccountType(){
        String[] signers = {"John Doe", "Jane Doe"};
        CD account = new CD("123456789", "CD", 0.01, 6, "11/17/2025", signers);
        assertEquals("CD", account.getAccountNumber());
    }
    @Test
    public void correctAccountSigners(){
        String[] signers = {"John Doe", "Jane Doe"};
        CD account = new CD("123456789", "CD", 0.01, 6, "11/17/2025", signers);
        assertEquals(signers, account.getAccountSigners());
    }
    @Test
    public void correctInterestRate(){
        String[] signers = {"John Doe", "Jane Doe"};
        CD account = new CD("123456789", "CD", 0.01, 6, "11/17/2025", signers);
        assertEquals(0.01, account.getInterestRate());
    }
    @Test
    public void correctTerm(){
        String[] signers = {"John Doe", "Jane Doe"};
        CD account = new CD("123456789", "CD", 0.01, 6, "11/17/2025", signers);
        assertEquals(6, account.getTerm());
    }
    @Test
    public void correctMaturity(){
        String[] signers = {"John Doe", "Jane Doe"};
        CD account = new CD("123456789", "CD", 0.01, 6, "11/17/2025", signers);
        assertEquals("11/17/2025", account.getMaturity());
    }
}
