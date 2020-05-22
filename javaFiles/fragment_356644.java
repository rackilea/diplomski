import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class GUI extends JFrame {

    JLabel CoffeeProgram;
    JButton button;
    JTextField textfield;
    JLabel outputPrice;
    JLabel outputDesc;

    public GUI() {
        setLayout(new FlowLayout());
        CoffeeProgram = new JLabel("Enter Code Here:");
        add(CoffeeProgram);
        textfield = new JTextField(15);
        add(textfield);
        outputPrice = new JLabel("Output price here");
        add(outputPrice);
        outputDesc = new JLabel("Desc: ");
        add(outputDesc);    
        button = new JButton("Submit Code");
        add(button);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            CoffeeReturn returnOutputPrice = new CoffeeReturn();
            double returnPrice = returnOutputPrice.CoffeeCode(1101101);
            outputPrice.setText(String.valueOf(returnPrice));

            String returnDescription = returnOutputPrice.CoffeeDesc(1101101);
            outputDesc.setText(returnDescription);
        }});

    }
}