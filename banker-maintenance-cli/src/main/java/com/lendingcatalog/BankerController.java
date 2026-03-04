package com.lendingcatalog;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BankerController {

    private Integer customersInSession = 0;
    private Integer accountsInSession = 0;

    private Map<String, String> customerDataInSession = new HashMap<>();

    private ArrayList<String> accountDataInSession = new ArrayList<>();


    private final BankerView view;
    private final File accountsFilePath = new File("src/main/resources/accounts.dat");
    private final File customersFilePath = new File("src/main/resources/customers.dat");

    public BankerController(BasicConsole console){
        view = new BankerView(console);
    }

    public void run(){
        displayMainMenu();
    }
    public void displayMainMenu(){
        final String MAIN_MENU_OPTION_ONE = "- Find Customer";
        final String MAIN_MENU_OPTION_TWO = "- Find Account";
        //final String MAIN_MENU_OPTION_THREE = "- Update Customer";
        //final String MAIN_MENU_OPTION_FOUR = "- Update Account";
        final String MAIN_MENU_OPTION_FIVE = "- Create Customer";
        final String MAIN_MENU_OPTION_SIX = "- Create Account";
        String[] menuOptions = {MAIN_MENU_OPTION_ONE, MAIN_MENU_OPTION_TWO, MAIN_MENU_OPTION_FIVE, MAIN_MENU_OPTION_SIX};
        view.displayHeader("BANKER SYSTEM");
        String userSelection = view.displayMainMenu(menuOptions);
        if (userSelection.equals("find customer")) {
            displayCustomerSearchMenu();
        }else if(userSelection.equals("find account")){
            displayAccountSearchMenu();
       // }else if(userSelection.equals("update customer")){

       // }else if(userSelection.equals("update account")){
            //displayUpdateAccountMenu();
        }else if(userSelection.equals("create customer")){
            displayCreateCustomerMenu();
        }else if(userSelection.equals("create account")){
            displayAccountCreationMenu();
        }
    }
    public void displayCustomerSearchMenu(){

        String[] customerDetails = new String[2];

        view.displayBlankLine();
        view.displayHeader("CUSTOMER SEARCH");
        String customerSSN = view.displayCustomerSocialPrompt();
        try(BufferedReader br = new BufferedReader(new FileReader(customersFilePath))){
            String line;

            while((line = br.readLine()) != null){
                if(line.contains(customerSSN)){
                    customerDetails = line.split("\\|");
                }
            }
        }catch(IOException e){
            view.displayMessage("error");
        }

        if(customerDetails[0] == null){
            view.displayMessage("CUSTOMER NOT FOUND. WOULD YOU LIKE TO CREATE ONE NOW?");
            String createCustYesNo = view.displayYesNo();
            if(createCustYesNo.equalsIgnoreCase("y")){
                displayCreateCustomerMenu();
            }else if(createCustYesNo.equalsIgnoreCase("n")){
                displayMainMenu();
            }
        }else{
            view.displayMessage("CUSTOMER FOUND. IS THIS CORRECT?");
            view.displayBlankLine();
            view.displayPrintData("SSN", customerDetails[0]);
            view.displayPrintData("Name", customerDetails[1]);
            view.displayBlankLine();
            String custYesNo = view.displayYesNo();
            if(custYesNo.equalsIgnoreCase("y")){
                customersInSession ++;
                customerDataInSession.put(customerDetails[0], customerDetails[1]);
                view.displayMessage("WOULD YOU LIKE TO SEARCH FOR ANOTHER CUSTOMER?");
                view.displayBlankLine();
                String userYesNo = view.displayYesNo();
                if(userYesNo.equalsIgnoreCase("y")){
                    displayCustomerSearchMenu();
                }else if(userYesNo.equalsIgnoreCase("n")){
                    displayMainMenu();
                }
            }else if(custYesNo.equalsIgnoreCase("n")){
                displayCustomerSearchMenu();
            }
        }
    }
    public void displayAccountSearchMenu(){
        ArrayList<String> accountDetails = null;
        view.displayBlankLine();
        view.displayHeader("ACCOUNT SEARCH");
        String accountNumber = view.displayAccountNumberSearch();
        try(BufferedReader br = new BufferedReader(new FileReader(accountsFilePath))){
            String line;
            while((line = br.readLine()) != null){
                if(line.contains(accountNumber)){
                    String[] dets = line.split("\\|");
                    for(int i = 0; i < dets.length; i++){
                        accountDetails.add(dets[i]);
                    }

                }
            }
        }catch(Exception e){

        }
        if(accountDetails == null){
            view.displayMessage("ACCOUNT NOT FOUND");
            displayMainMenu();
        }else{
            view.displayMessage("ACCOUNT FOUND. IS THIS CORRECT?");
            view.displayPrintData("Account Number", accountDetails.get(0));
            view.displayPrintData("Account Type", accountDetails.get(1));
            if(accountDetails.get(1).equalsIgnoreCase("cd")){
                view.displayPrintData("Interest Rate", accountDetails.get(2));
                view.displayPrintData("Maturity", accountDetails.get(3));
                for(int i = 4; i < accountDetails.size(); i++){
                    view.displayPrintData("Signer", accountDetails.get(i));
                }
                String userYesNo = view.displayYesNo();
                if(userYesNo.equalsIgnoreCase("y")){
                    accountsInSession ++;
                    for(int i = 0; i < accountDetails.size(); i++){
                        accountDataInSession.add(accountDetails.get(i));
                    }
                    displayMainMenu();
                }else if(userYesNo.equalsIgnoreCase("n")){
                    displayMainMenu();
                }
            }else if(accountDetails.get(1).equalsIgnoreCase("savings")){
                view.displayPrintData("Interest Rate", accountDetails.get(2));
                for(int i = 3; i < accountDetails.size(); i++){
                    view.displayPrintData("Signer", accountDetails.get(i));
                }
                String userYesNo = view.displayYesNo();
                if(userYesNo.equalsIgnoreCase("y")){
                    accountsInSession ++;
                    for(int i = 0; i < accountDetails.size(); i++){
                        accountDataInSession.add(accountDetails.get(i));
                    }
                    displayMainMenu();
                }else if(userYesNo.equalsIgnoreCase("n")){
                    displayMainMenu();
                }
            }else{
                for(int i = 2; i < accountDetails.size(); i++){
                    view.displayPrintData("Signer", accountDetails.get(i));
                }
                String userYesNo = view.displayYesNo();
                if(userYesNo.equalsIgnoreCase("y")){
                    accountsInSession ++;
                    for(int i = 0; i < accountDetails.size(); i++){
                        accountDataInSession.add(accountDetails.get(i));
                    }
                    displayMainMenu();
                }else if(userYesNo.equalsIgnoreCase("n")){
                    displayMainMenu();
                }
            }


        }
    }
    public void displayCreateCustomerMenu(){
        view.displayBlankLine();
        view.displayHeader("CREATE CUSTOMER");
        Customer newCustomer = new Customer(view.displayCustomerSocialPrompt(), view.displayCustomerFirstNamePrompt(), view.displayCustomerLastNamePrompt());
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(customersFilePath, true))){
            bw.newLine();
            bw.write(newCustomer.getSSN() + "|" + newCustomer.getFirstName() + " " + newCustomer.getLastName());
        }catch(Exception e){

        }
        view.displayMessage("CUSTOMER CREATED SUCCESSFULLY. WOULD YOU LIKE TO CREATE ANOTHER CUSTOMER?");
        view.displayBlankLine();
        String userInput = view.displayYesNo();
        if(userInput.equalsIgnoreCase("y")){
            displayCreateCustomerMenu();
        }else if(userInput.equalsIgnoreCase("n")){
            displayMainMenu();
        }
    }
    public void displayAccountCreationMenu(){
        view.displayHeader("ACCOUNT CREATION");
        view.displayBlankLine();
        if(customersInSession == 0){
            view.displayMessage("NO CUSTOMERS IN SESSION");
            view.displayMessage("WOULD YOU LIKE TO SEARCH NOW?");
            view.displayBlankLine();
            String userYesNo = view.displayYesNo();
            if(userYesNo.equalsIgnoreCase("y")){
                displayCustomerSearchMenu();
            }else if(userYesNo.equalsIgnoreCase("n")){
                displayMainMenu();
            }

        }else{
            String numSigners = view.displayGetNumSigners();
            if(Integer.parseInt(numSigners) < customersInSession){
                ArrayList<String> signersToAdd = new ArrayList<>();
                view.displayMessage("SIGNERS LESS THAN CUSTOMERS IN SESSION. PLEASE SELECT WHICH SIGNER(S) TO ADD.");
                for(Map.Entry<String, String> entry : customerDataInSession.entrySet()){
                    view.displayPrintData("Name", entry.getValue());
                    view.displayPrintData("SSN", entry.getKey());
                }
                view.displayBlankLine();
                for(int i = 0; i < Integer.parseInt(numSigners); i++){
                    signersToAdd.add(customerDataInSession.get(view.displayCustomerSocialPrompt()));
                }
                String accType = view.displayGetAccountTypePrompt();
                if(accType.equalsIgnoreCase("cd")){
                    String interestRate = view.displayGetInterestRate();
                    String term = view.displayGetTerm();
                    LocalDate maturity = LocalDate.now().plusMonths(Long.valueOf(term));
                    Random r = new Random();
                    long accNum = r.nextLong(999999999);
                    try(BufferedWriter bw = new BufferedWriter(new FileWriter(accountsFilePath, true))){
                        bw.newLine();
                        bw.write(String.valueOf(accNum) + "|CD|" + interestRate + "%|" + maturity + "|");
                        for(int i = 0; i < signersToAdd.size(); i++){
                            bw.write(signersToAdd.get(i) + "|");
                        }
                    }catch(Exception f){
                        view.displayMessage("error");
                    }
                    view.displayMessage("ACCOUNT CREATED SUCCESSFULLY. WOULD YOU LIKE TO CREATE ANOTHER?");
                    view.displayBlankLine();
                    view.displayPrintData("Account number", Long.toString(accNum));
                    view.displayBlankLine();
                    String userInput = view.displayYesNo();
                    if(userInput.equalsIgnoreCase("y")){
                        displayAccountCreationMenu();
                    }else{
                        displayMainMenu();
                    }
                }else if(accType.equalsIgnoreCase("ckg")){
                    Random r = new Random();
                    long accNum = r.nextLong(999999999);
                    try(BufferedWriter bw = new BufferedWriter(new FileWriter(accountsFilePath, true))){
                        bw.newLine();
                        bw.write(String.valueOf(accNum) + "|CHECKING|");
                        for(int i = 0; i < signersToAdd.size(); i++){
                            bw.write(signersToAdd.get(i) + "|");
                        }
                    }catch(Exception f){
                        view.displayMessage("error");
                    }
                    view.displayMessage("ACCOUNT CREATED SUCCESSFULLY. WOULD YOU LIKE TO CREATE ANOTHER?");
                    view.displayBlankLine();
                    view.displayPrintData("Account number", Long.toString(accNum));
                    view.displayBlankLine();
                    String userInput = view.displayYesNo();
                    if(userInput.equalsIgnoreCase("y")){
                        displayAccountCreationMenu();
                    }else{
                        displayMainMenu();
                    }
                }else if(accType.equalsIgnoreCase("svg")){
                    Random r = new Random();
                    long accNum = r.nextLong(999999999);
                    try(BufferedWriter bw = new BufferedWriter(new FileWriter(accountsFilePath, true))){
                        bw.newLine();
                        bw.write(String.valueOf(accNum) + "|SAVINGS|0.01%|");
                        for(int i = 0; i < signersToAdd.size(); i++){
                            bw.write(signersToAdd.get(i) + "|");
                        }
                    }catch(Exception f){
                        view.displayMessage("error");
                    }
                    view.displayMessage("ACCOUNT CREATED SUCCESSFULLY. WOULD YOU LIKE TO CREATE ANOTHER?");
                    view.displayBlankLine();
                    view.displayPrintData("Account number", Long.toString(accNum));
                    view.displayBlankLine();
                    String userInput = view.displayYesNo();
                    if(userInput.equalsIgnoreCase("y")){
                        displayAccountCreationMenu();
                    }else{
                        displayMainMenu();
                    }
                }

            }else if(Integer.parseInt(numSigners) > customersInSession){
                    view.displayMessage("SIGNERS REQUESTED GREATER THAN SIGNERS IN SESSION. WOULD YOU LIKE TO SEARCH FOR MORE SIGNERS?");
                    view.displayBlankLine();
                    String userInput = view.displayYesNo();
                    if (userInput.equalsIgnoreCase("y")) {
                        displayCustomerSearchMenu();
                    } else {
                        view.displayMessage("WOULD YOU LIKE TO CONTINUE WITH CURRENT NUMBER OF SIGNERS INSTEAD?");
                        view.displayBlankLine();
                        String userInputTwo = view.displayYesNo();
                        if (userInputTwo.equalsIgnoreCase("y")) {
                            displayAccountCreationMenu();
                        } else {
                            displayMainMenu();
                        }
                    }
            }else{
                String accType = view.displayGetAccountTypePrompt();
                if(accType.equalsIgnoreCase("cd")){
                    String interestRate = view.displayGetInterestRate();
                    String term = view.displayGetTerm();
                    LocalDate maturity = LocalDate.now().plusMonths(Long.valueOf(term));
                    Random r = new Random();
                    long accNum = r.nextLong(999999999);
                    try(BufferedWriter bw = new BufferedWriter(new FileWriter(accountsFilePath, true))){
                        bw.newLine();
                        bw.write(String.valueOf(accNum) + "|CD|" + interestRate + "%|" + maturity + "|");
                        for(Map.Entry<String, String> entry : customerDataInSession.entrySet()){
                            bw.write(entry.getValue() + "|");
                        }
                    }catch(Exception f){
                        view.displayMessage("error");
                    }
                    view.displayMessage("ACCOUNT CREATED SUCCESSFULLY. WOULD YOU LIKE TO CREATE ANOTHER?");
                    view.displayBlankLine();
                    view.displayPrintData("Account number", Long.toString(accNum));
                    view.displayBlankLine();
                    String userInput = view.displayYesNo();
                    if(userInput.equalsIgnoreCase("y")){
                        displayAccountCreationMenu();
                    }else{
                        displayMainMenu();
                    }
                }else if(accType.equalsIgnoreCase("ckg")){
                    Random r = new Random();
                    long accNum = r.nextLong(999999999);
                    try(BufferedWriter bw = new BufferedWriter(new FileWriter(accountsFilePath, true))){
                        bw.newLine();
                        bw.write(String.valueOf(accNum) + "|CHECKING|");
                        for(Map.Entry<String, String> entry : customerDataInSession.entrySet()){
                            bw.write(entry.getValue() + "|");
                        }
                    }catch(Exception f){
                        view.displayMessage("error");
                    }
                    view.displayMessage("ACCOUNT CREATED SUCCESSFULLY. WOULD YOU LIKE TO CREATE ANOTHER?");
                    view.displayBlankLine();
                    view.displayPrintData("Account number", Long.toString(accNum));
                    view.displayBlankLine();
                    String userInput = view.displayYesNo();
                    if(userInput.equalsIgnoreCase("y")){
                        displayAccountCreationMenu();
                    }else{
                        displayMainMenu();
                    }
                }else if(accType.equalsIgnoreCase("svg")){
                    Random r = new Random();
                    long accNum = r.nextLong(999999999);
                    try(BufferedWriter bw = new BufferedWriter(new FileWriter(accountsFilePath, true))){
                        bw.newLine();
                        bw.write(String.valueOf(accNum) + "|SAVINGS|0.01%|");
                        for(Map.Entry<String, String> entry : customerDataInSession.entrySet()){
                            bw.write(entry.getValue() + "|");
                        }
                    }catch(Exception f){
                        view.displayMessage("error");
                    }
                    view.displayMessage("ACCOUNT CREATED SUCCESSFULLY. WOULD YOU LIKE TO CREATE ANOTHER?");
                    view.displayBlankLine();
                    view.displayPrintData("Account number", Long.toString(accNum));
                    view.displayBlankLine();
                    String userInput = view.displayYesNo();
                    if(userInput.equalsIgnoreCase("y")){
                        displayAccountCreationMenu();
                    }else{
                        displayMainMenu();
                    }
                }
            }

        }
    }
}
