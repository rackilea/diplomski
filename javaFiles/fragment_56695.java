import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class DynamicTextFieldsApp
{
    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            JFrame f = new JFrame("JTextField Toggler");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);
            f.add(new DisplayPanel());
            f.pack();
            f.setLocationRelativeTo(null);
        }});
    }
}