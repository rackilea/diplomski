package com.zetcode;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;


public class MigLayoutGapGrow3 extends JFrame {

    public MigLayoutGapGrow3() {

        initUI();

        setTitle("Gaps");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }


    private void initUI() {

        setLayout(new MigLayout("wrap", "[grow, fill]"));

        add(new JTextField("a"+1), "id a1");
        add(new JTextField("a"+2));
        add(new JTextField("a"+3));
        add(new JTextField("a"+4));
        add(new JTextField("a"+5));

        final JLabel status = new JLabel("status line");
        add(status, "pos a1.x visual.y2-p");

        pack();
    }


    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MigLayoutGapGrow3 ex = new MigLayoutGapGrow3();
                ex.setVisible(true);
            }
        });
    }
}