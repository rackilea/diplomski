package com.example.resistorcalculator;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 */
public class ResistorCalculatorApplication {

    JFrame mainWindow;

    private double sum = 0.0;



    public static void main(String ...args) {
        new ResistorCalculatorApplication().run();
    }

    private void run() {
        mainWindow = build();
        mainWindow.pack();
        mainWindow.setVisible(true);
    }


    private class CalculatorSetValueActionListener implements ActionListener {

        private final double value; 

        public CalculatorSetValueActionListener(double value) {
            this.value = value;
        }


        @Override
        public void actionPerformed(ActionEvent e) {
            sum = this.value;
            System.out.println("Sum = " + sum);
        }

    }



    private class CalculatorAddValueActionListener implements ActionListener {

        private final double value; 

        public CalculatorAddValueActionListener(double value) {
            this.value = value;
        }


        @Override
        public void actionPerformed(ActionEvent e) {
            sum += this.value;
            System.out.println("Sum = " + sum);
        }

    }

    private class CalculatorMultipierValueActionListener implements ActionListener {

        private final double value; 

        public CalculatorMultipierValueActionListener(double value) {
            this.value = value;
        }


        @Override
        public void actionPerformed(ActionEvent e) {
            sum *= this.value;
            System.out.println("Sum = " + sum);
        }

    }


    private JFrame build() {
        JFrame window = new JFrame("Example");
        Container contentPane = window.getContentPane(); 


        window.setLayout(new GridLayout(2,3));
        JButton b11 = new JButton("Black - 0");
        b11.addActionListener(new CalculatorSetValueActionListener(0.0));

        contentPane.add(b11);

        JButton b12 = new JButton("Black - 0");
        b12.addActionListener(new CalculatorAddValueActionListener(0.0));

        contentPane.add(b12);


        JButton b13 = new JButton("Black - 0");
        b13.addActionListener(new CalculatorMultipierValueActionListener(1.0));

        contentPane.add(b13);




        JButton b21 = new JButton("Brown - 1");
        b21.addActionListener(new CalculatorSetValueActionListener(10.0));

        contentPane.add(b21);


        JButton b22 = new JButton("Brown - 1");
        b22.addActionListener(new CalculatorAddValueActionListener(1.0));

        contentPane.add(b22);


        JButton b23 = new JButton("Brown - 1");
        b23.addActionListener(new CalculatorMultipierValueActionListener(10.0));

        contentPane.add(b23);


        return window;

    }

}