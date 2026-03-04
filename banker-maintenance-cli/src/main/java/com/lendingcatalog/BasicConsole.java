package com.lendingcatalog;

public interface BasicConsole {

    void printBanner(String message);
    void printMessage(String message);
    void printBlankLine();
    void printData(String title, String data);

    String getMainMenuSelection(String[] menuOptions);
    String getCustomerName();
    String getAccountNumber();
    String getUserYesNo();
    String getCustomerSocial();
    String getCustomerFirstName();
    String getCustomerLastName();
    String getAccountType();
    String getNumSigners();
    String getInterestRate();
    String getTerm();


}
