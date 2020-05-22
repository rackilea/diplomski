import java.awt.event.ActionListener;
import java.io.*;
import java.util.*; 
import javax.comm.*;
import javax.swing.*;

public class SimpleRead  {
    static Enumeration portList;
    static CommPortIdentifier portId;
    static PrintStream os;
    static BufferedReader is;
    static java.util.Timer t = new java.util.Timer();
    static TimersTask tt = new TimersTask();

    public static void main(String[] args) {

        GUI GUI = new GUI();
        JFrame window = new JFrame("DI-100"); 
        window.setSize(700, 300); 
        window.setVisible(true); 
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(GUI);

        Enumeration portList = CommPortIdentifier.getPortIdentifiers();
        String wantedPortName;
        CommPortIdentifier portId = (CommPortIdentifier) portList.nextElement();
        if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
            ArrayList<String> serialports = new ArrayList<String>();
            serialports.add(portId.getName());
            String[] ports = new String[serialports.size()];
            ports = serialports.toArray(ports); 
            GUI.jComboBox2 = new JComboBox(ports);
            GUI.jComboBox2.addActionListener(GUI.jComboBox2);
            wantedPortName = (String) GUI.jComboBox2.getSelectedItem();


            while (portList.hasMoreElements()) { 
                if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL &&
                  portId.getName().equals(wantedPortName)) {
                    CommPortIdentifier pid = portId;
                    SerialPort port = null;


                    try {
                        port = (SerialPort) portId.open("OpenPort", 1000);
                        port.setSerialPortParams(9600,SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE);
                        os = new PrintStream(port.getOutputStream(), true, "ISO-8859-1");
                        is = new BufferedReader(new InputStreamReader(port.getInputStream()));
                        os = new PrintStream(port.getOutputStream(), true); // you had this line in your original code.  Is this really necessary, since you have a similar line 2 lines before it?
                    } catch(PortInUseException e) {
                        System.err.println("Port already in use: " + e);
                    } catch (UnsupportedCommOperationException e) {
                        System.out.println("you suck");
                    } catch (IOException e) {
                        System.err.println("Can't open input or output stream");
                    }
                }
                else {
                }
            }
        }
        try {
            os.close();
        } catch (Exception ex) {
            //already closed
        }
        try {
            is.close();
        } catch (Exception ex) {
            //already closed
        }
        // close the port here
    }
}