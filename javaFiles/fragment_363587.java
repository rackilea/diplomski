import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

// no need to extend frame!
//public class Calculator extends JFrame {
public class Calculator {

    public Calculator(){    
        initComponents();    
    }

    private void initComponents(){
        // I find it easier to create a panel and SET it as the content pane
        JPanel gui = new JPanel(new BorderLayout(5,5));
        // add some padding to the main GUI
        gui.setBorder(new EmptyBorder(4,4,4,4));

        // not needed if only a single compoinent is to be added!
        //JPanel panelScreen = new JPanel(new GridLayout(0,1));

        // add some constraints to make the output field bigger.
        // if it is intended to be single line, a JTextField should be used.
        JTextArea screen = new JTextArea(2,25);
        gui.add(screen, BorderLayout.NORTH);
        //panelScreen.add(screen);

        JFrame frame = new JFrame("CALCULATOR");
        frame.setContentPane(gui);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // add padding around the buttons
        JPanel panelButtons = new JPanel(new GridLayout(3,3,4,4));

        JButton oneButton = new JButton("1");
        panelButtons.add(oneButton);

        JButton twoButton = new JButton("2");
        panelButtons.add(twoButton);

        JButton threeButton = new JButton("3");
        panelButtons.add(threeButton);

        JButton fourButton = new JButton("4");
        panelButtons.add(fourButton);

        JButton fiveButton = new JButton("5");
        panelButtons.add(fiveButton);

        JButton sixButton = new JButton("6");
        panelButtons.add(sixButton);

        JButton sevenButton = new JButton("7");
        panelButtons.add(sevenButton);

        JButton eightButton = new JButton("8");
        panelButtons.add(eightButton);

        JButton nineButton = new JButton("9");
        panelButtons.add(nineButton);

        //frame.getContentPane().add(new JSeparator(), BorderLayout.CENTER);

        // Add the buttons to the CENTER and they will
        // fill whatever space they are provided.
        gui.add(panelButtons, BorderLayout.CENTER);
        //frame.setBounds(50, 50, 500, 500);
        //frame.setResizable(false);
        frame.pack();
        frame.setVisible(true); 
    }    

    public static void main(String[] args) {    
       java.awt.EventQueue.invokeLater(new Runnable() {

         @Override
         public void run() {
            new Calculator();
         }
       });    
    }    
}