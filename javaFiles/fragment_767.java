//Your main method
public static void main(String[] args){
    // Create a variable for your new GUI object
    GUI gui = new GUI();
    // Pass our new GUI variable to the Credit object we're creating
    Credit credit = new Credit(gui);

    // Lets set some text
    GUI.LCDString = "Hello World";
    // If LCDString was not static it would be something like this:
    // gui.setLCDString("Hello World");

    // Now we have a credit instance and can call the reset() method on this object
    credit.reset();
}