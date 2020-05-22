package hellofx;

import java.awt.Desktop;

import javafx.application.Application;

public class HelloFX {

    public static void main(String[] args) {
        registerForMacOSXEvents();
        Application.launch(Appl.class, args);
    }

    protected static void registerForMacOSXEvents() {
        Desktop desktop = Desktop.getDesktop();
        desktop.setAboutHandler(e -> System.out.println("About"));
    }

}