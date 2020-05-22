public class Credit {
    // Keep a reference to your jframe, so you can call non-static public methods on it
    private GUI gui;

    // Pass a GUI object to your Credit object
    public Credit(GUI gui){
        this.gui = gui;
    }

    // This should also probably not be a static method.
    // Note: methods in Java should start with a lowercase letter
    public void reset(){
        gui.refreshLCD();
    }
}