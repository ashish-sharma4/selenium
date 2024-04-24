package com.speedhire.selenium;

import com.speedhire.selenium.server.JettyServer;

public class AppMain {
    public static final int APP_PORT = 9090;
    public static void main(String[] args) {
        System.out.println("Starting server at port " + APP_PORT);
        JettyServer server = new JettyServer(APP_PORT);
        server.start();
        System.out.println("Started server at port " + APP_PORT);
    }
}
