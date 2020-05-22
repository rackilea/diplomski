package com.company;
import java.util.prefs.Preferences;
public class Main {

// This key will be used to access the preference, could literally have any name and value
private static final String SOME_KEY = "some_key";

private Preferences preferences;

public Main(){
    // Defining a new node for saving preference. Analogoues to a location.
    preferences = Preferences.userRoot().node(this.getClass().getSimpleName());
}

public boolean firstRun(){
    // See what is save in under SOME_KEY, if nothing found return true, if something found, return that.
    return preferences.getBoolean(SOME_KEY, true);
}

public void run(){
    // Put the value of false in the preference with the key SOME_KEY
    preferences.putBoolean(SOME_KEY, false);
}



public static void main(String[] args) {
    Main main = new Main();
    System.out.println("Is this the frist time running this app?");
    System.out.println(main.firstRun());
    main.run();

}
}