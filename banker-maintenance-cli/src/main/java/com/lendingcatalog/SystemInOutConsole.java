package com.lendingcatalog;

import java.util.Scanner;

public class SystemInOutConsole implements BasicConsole{

    private final Scanner input = new Scanner(System.in);

    @Override
    public void printBanner(String message) {
        String dashes = "-".repeat(message.length());
        System.out.println(dashes);
        System.out.println(message);
        System.out.println(dashes);
    }

    @Override
    public void printMessage(String message) {
        String asterik = "*".repeat(message.length());
        System.out.println(asterik);
        System.out.println(message);
        System.out.println(asterik);
    }

    @Override
    public void printBlankLine() {
        System.out.println();
    }

    @Override
    public void printData(String title, String data) {
        System.out.println(title + ": " + data);
    }

    @Override
    public String getMainMenuSelection(String[] menuOptions) {

        System.out.println();

        for(int i = 0; i < menuOptions.length; i++){
            System.out.println(menuOptions[i]);
        }
        System.out.println();
        System.out.print("Enter selection: ");
        String selection = input.nextLine();

        return selection.toLowerCase();
    }

    @Override
    public String getCustomerName() {
        System.out.println();
        System.out.print("Name: ");
        String customerName = input.nextLine();
        return customerName;
    }

    @Override
    public String getAccountNumber() {
        System.out.println();
        System.out.print("Account Number: ");
        String accountNumber = input.nextLine();
        return accountNumber;
    }

    @Override
    public String getUserYesNo() {
        System.out.print("Y/N: ");
        String userInput = input.nextLine();
        return userInput;
    }

    @Override
    public String getCustomerSocial() {
        System.out.print("SSN: ");
        String userInput = input.nextLine();
        return userInput;
    }

    @Override
    public String getCustomerFirstName() {
        System.out.print("First Name: ");
        String userInput = input.nextLine();
        return userInput;
    }

    @Override
    public String getCustomerLastName() {
        System.out.print("Last Name: ");
        String userInput = input.nextLine();
        return userInput;
    }

    @Override
    public String getAccountType() {
        System.out.print("Account Type (CKG,SVG,CD): ");
        String userInput = input.nextLine();
        return userInput;
    }

    @Override
    public String getNumSigners() {
        System.out.print("Number Of Signers: ");
        String userInput = input.nextLine();
        return userInput;
    }

    @Override
    public String getInterestRate() {
        System.out.print("Interest rate: ");
        String userInput = input.nextLine();
        return userInput;
    }

    @Override
    public String getTerm() {
        System.out.print("Term: ");
        String userInput = input.nextLine();
        return userInput;
    }
}
