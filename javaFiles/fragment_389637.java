import griffon.swing.SwingApplet;  

public class MySwingApplet extends SwingApplet {
    // match superclass constructors
    public CalculatorApplet(String[] args) {  
        super(args);  
    }  

    public Object myAppletMethod(String[] args) {
        // args come form the JS world
        // do whatever is necessary here
    }
}