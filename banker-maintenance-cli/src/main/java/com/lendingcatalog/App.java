package com.lendingcatalog;

public class App {

    public static void main(String[] args) {
        SystemInOutConsole systemInOutConsole = new SystemInOutConsole();
        BankerController controller = new BankerController(systemInOutConsole);

        controller.run();
    }

}
