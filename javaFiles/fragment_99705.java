package com.zetcode;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;


public class MigLayoutGapGrow2 extends JFrame {

    public MigLayoutGapGrow2() {

        initUI();

        setTitle("Gaps");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }


    private void initUI() {

        setLayout(new MigLayout("wrap, debug", "[grow, fill]"));

        add(new JTextField("a"+1));
        add(new JTextField("a"+2));
        add(new JTextField("a"+3));
        add(new JTextField("a"+4));
        add(new JTextField("a"+5));

        final JLabel status = new JLabel("status line");
        add(status, "pushy, bottom");

        pack();
    }


    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MigLayoutGapGrow2 ex = new MigLayoutGapGrow2();
                ex.setVisible(true);
            }
        });
    }
}