import javax.swing.*;

public class Main {


    public static void main(String[] args){
        // Check to make sure you have args first, we do not want an exception
        if(args.length > 0){
            String pin = args[0];
            String file = args[1];

            // Insert some args check to make sure they are what you expected, length wise, or
            // even convert to numbers

            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    // Do stuff with args
                    PIN = pin;
                    FILE = file;
                }
            });
        } else {
            // No args oh shoot.
        }
    }
}