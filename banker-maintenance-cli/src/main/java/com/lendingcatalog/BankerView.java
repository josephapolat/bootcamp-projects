package com.lendingcatalog;

public class BankerView {

    private final BasicConsole console;

    public BankerView(BasicConsole console) {

        this.console = console;
    }
    public void displayHeader(String header){
        console.printBanner(header);
    }
    public String displayMainMenu(String[] menuOptions){
        return console.getMainMenuSelection(menuOptions);
    }
    public String displayCustomerNameSearch(){
        return console.getCustomerName();
    }
    public String displayAccountNumberSearch(){return console.getAccountNumber();}
    public void displayMessage(String message){
        console.printMessage(message);
    }
    public void displayBlankLine(){
        console.printBlankLine();
    }
    public void displayPrintData(String title, String data){
        console.printData(title, data);
    }
    public String displayYesNo(){
        return console.getUserYesNo();
    }
    public String displayCustomerSocialPrompt(){
        return console.getCustomerSocial();
    }
    public String displayCustomerFirstNamePrompt(){
        return console.getCustomerFirstName();
    }
    public String displayCustomerLastNamePrompt(){
        return console.getCustomerLastName();
    }
    public String displayGetAccountTypePrompt(){
        return console.getAccountType();
    }
    public String displayGetNumSigners(){
        return console.getNumSigners();
    }
    public String displayGetInterestRate(){
        return console.getInterestRate();
    }
    public String displayGetTerm(){
        return console.getTerm();
    }
}
