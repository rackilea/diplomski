... //Imports and package declaration

public class ArduinoGUI implements SerialPortEventListener {

    private String inputLine;
    private JLabel lblTxt;

    ... //Other private variables, initialize2(), and close()

    public synchronized void serialEvent(SerialPortEvent oEvent) {
        if(oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                inputLine = input.readLine(); //Don't forget to use the                             
                                              //class-level scope variable here
                System.out.println(inputLine);
                lblTxt.setText(inputLine); //.toString() unnessesary since 
                                           //inputLine is a String
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    ... //Main method and constructor

    private void initialize() {
        ... //GUI stuff
        lblTxt = new JLabel("txt"); //Don't forget to use the 
                                    //class-level scope variable here too
        ... //Adding lblTxt to frame
        lblTxt.setText(inputLine); //Again, .toString() unnessesary
    }
}