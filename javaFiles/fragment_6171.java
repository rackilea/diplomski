import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ExampleClass{    

    public static void main(String args[]){

        JFrame exampleFrame = new JFrame("Test");          
        exampleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        exampleFrame.setLayout(new FlowLayout());
        exampleFrame.setSize(300, 300);

        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.RED);
        redPanel.setPreferredSize(new Dimension(150, 300));
        redPanel.setCursor(new Cursor(Cursor.HAND_CURSOR)); // This one line changes the cursor.

        exampleFrame.add(redPanel);
        exampleFrame.setVisible(true);            
    }
}