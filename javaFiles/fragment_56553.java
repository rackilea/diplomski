import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InvokeLaterEffect {

    static JTextArea text = new JTextArea();


    // See the diff by commenting.
    static void done() {
        SwingUtilities.invokeLater( doneAction ); 
        //doneAction.run();
    }


    public static void main( String [] args ) {
        JFrame frame = new JFrame();
        frame.add( text );
        frame.pack();
        frame.setVisible( true );

        bacgroundTask.start();
    }
    // run a task in the background
    static Thread bacgroundTask = new Thread(){
        public void run(){
            try { 
                System.out.println( Thread.currentThread().getName() + " Started background task ");
                Thread.sleep( 5000 );
                System.out.println( Thread.currentThread().getName() + " Finished background task");
                done();
            } catch ( InterruptedException ie ){}
        }
    };

    // called whtn id done
    static Runnable doneAction = new Runnable(){
        public void run(){
            System.out.println( Thread.currentThread().getName() + " start setting text ");
            text.setText("Hello");
            System.out.println( Thread.currentThread().getName() + " finish setting text ");
        }
    };


}