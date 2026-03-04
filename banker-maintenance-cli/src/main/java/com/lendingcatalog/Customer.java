package com.lendingcatalog;

public class Customer {

    String SSN;
    String firstName;
    String lastName;

    public Customer(String ssn, String firstName, String lastName){
        this.SSN = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getSSN(){
        return SSN;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
}
