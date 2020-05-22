import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Part3Question1 extends JPanel {
    private JTextField fahrenheitTB;
    private JTextField celsiusResultTB;
    private JButton tryAgain;

    public Part3Question1() {
        Color color = new Color(255, 0, 0);

        JLabel fahrenheitLabel = new JLabel("Enter Fahrenheit temperature:");
        add(fahrenheitLabel);

        fahrenheitTB = new JTextField(5);
        fahrenheitTB.setHorizontalAlignment(fahrenheitTB.CENTER);
        // updated
        fahrenheitTB.requestFocusInWindow();
        add(fahrenheitTB);

        JLabel celsiusLabel = new JLabel("Temperature in Celsius: ");
        add(celsiusLabel);

        celsiusResultTB = new JTextField(5);
        celsiusResultTB.setForeground(color);
        celsiusResultTB.setEditable(false);
        celsiusResultTB.setHorizontalAlignment(celsiusResultTB.CENTER);
        add(celsiusResultTB);

        JButton convertButton = new JButton("Convert!");
        add(convertButton);

        tryAgain = new JButton("Try Again!");
        tryAgain.setVisible(false);
        add(tryAgain);

        convertButton.addActionListener(new myFirstActionListener());
        tryAgain.addActionListener(new mysecondActionListener());
    }

    private class myFirstActionListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            int fahrenheitTemp, celsiusTemp;
            String text = fahrenheitTB.getText();
            try {
                fahrenheitTemp = Integer.parseInt(text);
                celsiusTemp = (fahrenheitTemp - 32) * 5 / 9;
                celsiusResultTB.setText(Integer.toString(celsiusTemp));
                tryAgain.setVisible(true);

            } catch (NumberFormatException e) {
                String myException = "Invalid entry. Please enter Integers Only";
                JOptionPane.showMessageDialog(null, myException);
                fahrenheitTB.setText("");
            }finally{
                // updated
                fahrenheitTB.requestFocusInWindow();
                    }
        }
    }

    private class mysecondActionListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            fahrenheitTB.setText("");
            // updated
            fahrenheitTB.requestFocusInWindow();
            celsiusResultTB.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame myFrame = new JFrame();
                myFrame.setTitle("Fahrenheit to Celsius Converter");
                myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                myFrame.setPreferredSize(new Dimension(300, 150));
                myFrame.setLocation(400, 300);
                Part3Question1 panel = new Part3Question1();
                myFrame.getContentPane().add(panel);
                myFrame.pack();
                myFrame.setVisible(true);

            }
        });
    }
}