public class Display {
    private ArrayControl arrayControl;

    public Display() {
        // Pass this instance of Display to ArrayControl to use
        arrayControl = new ArrayControl(this);
        arrayControl.updatePosition("Test", 2, 3);
    }

    public void updateGrid(String name, int x, int y) {
        // Do update grid stuff
    }

}

public class ArrayControl {

    private Display display;

    public ArrayControl(Display display) {
        this.display = display; // assign instance of Display to the field display
    }

    public void updatePosition(String name, int x, int y) {
        display.updateGrid(name, x, y);
        // I'm not sure why you want to pass the display back to the
        // Display class as in your example so I removed it
    }

}