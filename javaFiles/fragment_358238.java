import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Calculator extends JApplet implements ActionListener {
    private JLabel num1_label;
    private JLabel num2_label;
    private JLabel result_label;
    private JTextField t1;
    private JTextField t2;
    private JTextField t3;
    private JButton sum;
    private JButton sub;
    private JButton mul;
    private JButton div;
    private float num1;
    private float num2;
    private float res;

    public Calculator() {
        Container contentPanel = getContentPane();
        contentPanel.setLayout(new GridLayout(6, 2));

        num1_label = new JLabel("Number 1");
        contentPanel.add(num1_label);

        t1 = new JTextField(10);
        contentPanel.add(t1);

        num2_label = new JLabel("Number 2");
        contentPanel.add(num2_label);

        t2 = new JTextField(10);
        contentPanel.add(t2);

        result_label = new JLabel("Result");
        contentPanel.add(result_label);

        t3 = new JTextField(10);
        contentPanel.add(t3);

        sum = new JButton("Add");
        sum.addActionListener(this);
        contentPanel.add(sum);

        sub = new JButton("Subtract");
        sub.addActionListener(this);
        contentPanel.add(sub);

        mul = new JButton("Multiply");
        mul.addActionListener(this);
        contentPanel.add(mul);

        div = new JButton("Divide");
        div.addActionListener(this);
        contentPanel.add(div);
    }

    public void actionPerformed(ActionEvent ae) {
        System.out.println("hhhhh");
        if (ae.getSource() == sum) {
            addition();
        }

        if (ae.getSource() == sub) {
            subtraction();
        }

        if (ae.getSource() == mul) {
            multiplication();
        }

        if (ae.getSource() == div) {
            division();
        }
    }

    public void addition() {
        try {
            num1 = Float.parseFloat(t1.getText());
            num2 = Float.parseFloat(t2.getText());
            res = num1 + num2;
            t3.setText(" " + res);
        } catch (NumberFormatException nfe) {
            t1.setText("0");
            t2.setText("0");
            t3.setText("0");
        }

    }

    public void subtraction() {
        try {
            num1 = Float.parseFloat(t1.getText());
            num2 = Float.parseFloat(t2.getText());
            res = num1 - num2;
            t3.setText(" " + res);
        } catch (NumberFormatException nfe) {
            t1.setText("0");
            t2.setText("0");
            t3.setText("0");
        }
    }

    public void multiplication() {
        try {
            num1 = Float.parseFloat(t1.getText());
            num2 = Float.parseFloat(t2.getText());
            res = num1 * num2;
            t3.setText(" " + res);
        } catch (NumberFormatException nfe) {
            t1.setText("0");
            t2.setText("0");
            t3.setText("0");
        }
    }

    public void division() {
        try {
            num1 = Float.parseFloat(t1.getText());
            num2 = Float.parseFloat(t2.getText());
            res = num1 / num2;
            t3.setText(" " + res);
        } catch (NumberFormatException nfe) {
            t1.setText("0");
            t2.setText("0");
            t3.setText("0");
        }

    }

    public static void main(String argsp[]) {
        Calculator c = new Calculator();
    }

}