package main;
public class Main {
    // private GUI gui; // replaced this line with the below. See comment 5
    private static GUI gui; // this is the new field declaration

    public static void main(String[] args) {
        gui = new GUI(); // note I removed the class declaration here since it was declared above.
        gui.setVisible(true);

        Serial serial = new Serial();
        serial.getPorts();
        fillList();
    }

    public void fillList () {
        gui.setList("hoi"); // now this method has access to the gui field 
    }
}