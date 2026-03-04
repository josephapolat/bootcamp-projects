package com.lendingcatalog;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {
    @Test
    public void correctSSN(){
        Customer customer = new Customer("123456789", "John", "Doe");
        assertEquals("123456789", customer.getSSN());
    }
    @Test
    public void correctFirstName(){
        Customer customer = new Customer("123456789", "John", "Doe");
        assertEquals("John", customer.getFirstName());
    }
    @Test
    public void correctLastName(){
        Customer customer = new Customer("123456789", "John", "Doe");
        assertEquals("Doe", customer.getLastName());
    }
}
