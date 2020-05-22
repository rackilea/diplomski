import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class CountClicks{
    public static void main(String[] args){

        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                JFrame frame = new JFrame("Counting individual clicks");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new DrawingSpace());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);                 
            }
        }); 
    }
}