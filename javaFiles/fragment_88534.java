/*
 *
 * Currency converting
 *
 */

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

import javax.swing.UIManager;

public class CurrencyConverterWin extends JFrame {

    private JLabel promptLabel;
    private JTextField amountField;
    private JButton goButton;
    private JPanel inputPanel;
    private JPanel answerPanel;
    private JLabel answerLabel;
    private JLabel selectLabel;
    private JComboBox currencyMenuBar;
    private JPanel menuPanel;
    private double result = 0.0;
    private double euro = 1.22257;
    private double japYen = 152.073;
    private double rusRuble = 42.5389;
    private double usd = 1.5577;

    public CurrencyConverterWin() {
        super();
        this.setSize(500, 200);
        this.setTitle("Currency Converter Window");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new GridLayout(3, 1));

        this.selectLabel = new JLabel("Select a currency to convert to: ", JLabel.RIGHT);
        this.answerLabel = new JLabel(" ", JLabel.CENTER);

        currencyMenuBar = new JComboBox(new String[]{"Euros","Japanese Yen","Russian Rubles","US Dollars"});

        this.menuPanel = new JPanel();
        this.menuPanel.add(this.selectLabel);
        this.menuPanel.add(this.currencyMenuBar);
        this.add(this.menuPanel);

        this.promptLabel = new JLabel("(select a currency first) ", JLabel.RIGHT);
        this.answerLabel = new JLabel(" ", JLabel.CENTER);

        this.amountField = new JTextField("", 8);
        this.goButton = new JButton("GO");
        goButton.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClicked(evt);
            }
        });

        this.inputPanel = new JPanel();
        this.inputPanel.add(this.promptLabel);
        this.inputPanel.add(this.amountField);
        this.inputPanel.add(this.goButton);

        this.add(this.inputPanel);

        this.answerPanel = new JPanel();
        this.answerPanel.add(this.answerLabel);
        this.add(this.answerPanel);
    }

    double EuroToSterling() {
        double total = Double.parseDouble(amountField.getText()) * euro;
        return total;
    }

    double JapYenToSterling()
    {
        double japToSterlingTotal = Double.parseDouble(amountField.getText()) * japYen;
        return japToSterlingTotal;
    }


//String currencyEntered = yearField.getText();
    public void buttonClicked(ActionEvent evt) {
        if(currencyMenuBar.getSelectedItem().equals("Euros"))
        {
            answerLabel.setText(EuroToSterling() + " Euros");
        }
        if(currencyMenuBar.getSelectedItem().equals("Japanese Yen"))
        {
            answerLabel.setText(JapYenToSterling() + " Japanese Yen");
        }
    }

    public static void main(String[] args) {        
        try{UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");}
        catch (Exception e){e.printStackTrace();}
        CurrencyConverterWin win = new CurrencyConverterWin();
        win.setVisible(true);
    }
}