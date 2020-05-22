import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public abstract class demo extends Frame implements ActionListener
{      
   public demo() {}
    public static void main (String args[]) {
    try {
         JWindow window = new JWindow();
         window.getContentPane().add(new JLabel(new ImageIcon("/home/ubuntu/NetBeansProjects/demo/gimpsplash.gif"), SwingConstants.CENTER));
         window.setBounds(500, 150, 300, 200);
         window.setVisible(true);
         try 
         {
             Thread.sleep(5000);
         } catch (InterruptedException e) 
         {}
         window.setVisible(false);
         JFrame frame = new JFrame();
         frame.add(new JLabel("Welcome Swing application for Ashish.."));
         frame.setVisible(true);
         frame.setSize(300,200);
         window.dispose();
       } catch (Exception ex) {
        Logger.getLogger(Kapildemo.class.getName()).log(Level.SEVERE, null, ex);
    }
}
}