package com.zetcode;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import net.miginfocom.swing.MigLayout;


public class MigLayoutAlignmentEx extends JFrame {

    public MigLayoutAlignmentEx() {

        initUI();
    }

    private void initUI() {

        setLayout(new MigLayout());

        JLabel lbl1 = new JLabel("Action");
        JLabel lbl2 = new JLabel("Choose Selector");
        JLabel lbl3 = new JLabel("Element Properties");
        JLabel lbl4 = new JLabel("Values");
        JLabel lbl5 = new JLabel("Element Name");
        JLabel lbl6 = new JLabel("Comments");

        JComboBox combo1 = new JComboBox();
        JComboBox combo2 = new JComboBox();

        JTextField field1 = new JTextField(15);
        JTextField field2 = new JTextField(15);
        JTextField field3 = new JTextField(15);
        JTextField field4 = new JTextField(15);

        add(lbl1);
        add(lbl2);
        add(lbl3);
        add(lbl4);
        add(lbl5);
        add(lbl6, "wrap");

        add(combo1, "w 150lp");
        add(combo2, "w 150lp");
        add(field1);
        add(field2);
        add(field3);
        add(field4, "wrap");

        pack();

        setTitle("MigLayout example");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    }


    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            MigLayoutAlignmentEx ex = new MigLayoutAlignmentEx();
            ex.setVisible(true);
        });        
    }
}