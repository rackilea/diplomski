package examples;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ButtonDemo extends JFrame 
{
    private JButton squareButton;
    private JButton resetButton;
    private JLabel numberLabel;
    private JLabel squareLabel;

    private JTextField numberField;
    private  JTextField squareField;


    public ButtonDemo()
    {

        Container container=getContentPane();
        container.setLayout(new FlowLayout());

        Panel panel1= new Panel();
        Panel panel2= new Panel();
        Panel panel3 = new Panel();
        panel1.setLayout(new FlowLayout());

        squareButton = new  JButton("Square");
        resetButton = new  JButton("Reset");

        numberLabel = new JLabel("Number");
        squareLabel = new JLabel("Square");

        numberField = new JTextField();
        numberField.setColumns(8);

        squareField = new JTextField();
        squareField.setColumns(8);

        panel3.add(panel1);
        panel3.add(panel2);

        panel1.add(numberLabel);
        panel1.add(squareLabel);
        panel1.add(numberField);
        panel1.add(squareField);

        panel2.add(squareButton);
        panel2.add(resetButton);

        container.add(panel1);
        container.add(panel2);
        container.add(panel3);

        squareButton.addActionListener(e -> handleSquareButtonClick(e));
        resetButton.addActionListener(e -> handleresetButtonClick(e));

        setSize(500,500);
        setVisible(true);
    }

    private void handleresetButtonClick(ActionEvent e) 
    {
        this.numberField.setText(null);
        this.squareField.setText(null);
    }

    private void handleSquareButtonClick(ActionEvent e)
    {
        try
        {
            double number = Double.parseDouble(this.numberField.getText());
            this.squareField.setText(String.valueOf(number * number));
        }
        catch (NumberFormatException ex)
        {
            System.out.println(ex.getMessage());
        }

    }

    public static void main(String args[])
    {
        ButtonDemo application = new ButtonDemo();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}//end of  class Buttondemo