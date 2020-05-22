package com.zetcode;

import java.awt.EventQueue;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;



public class MigLayoutPushEx extends JFrame {

    public MigLayoutPushEx() {

        initUI();

        setTitle("Gaps");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initUI() {

        setLayout(new MigLayout("insets 5"));

        final JLabel[] labels = {new JLabel("Area 1"), 
            new JLabel("Area 2"), new JLabel("Area 3")};

        for (final JLabel l : labels) {
            l.setHorizontalAlignment(JLabel.CENTER);
            l.setBorder(BorderFactory.createEtchedBorder());
        }

        add(labels[0], "w 200");
        add(labels[1], "w 200, h 200, spany 2, pushx, grow, wrap");
        add(labels[2], "w 200, grow, pushy");

        pack();
    }    


    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MigLayoutPushEx ex = new MigLayoutPushEx();
                ex.setVisible(true);
            }
        });
    }        
}