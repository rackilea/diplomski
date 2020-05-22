package com.zetcode;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.GroupLayout.Alignment.CENTER;
import static javax.swing.GroupLayout.Alignment.TRAILING;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;


public class GroupLayoutTriangle extends JFrame {

    public GroupLayoutTriangle() {

        initUI();

        setTitle("GroupLayout triangle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initUI() {

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        JLabel heightLbl = new JLabel("Height:");
        JLabel baseLbl = new JLabel("Base:");
        JLabel side2Lbl = new JLabel("Side 2:");
        JLabel side3Lbl = new JLabel("Side 3:");

        JTextField field1 = new JTextField(10);
        JTextField field2 = new JTextField(10);
        JTextField field3 = new JTextField(10);
        JTextField field4 = new JTextField(10);

        JButton calcBtn = new JButton("Calculate");

        JPanel imgPanel = new JPanel();
        imgPanel.setPreferredSize(new Dimension(150, 150));
        imgPanel.setMaximumSize(new Dimension(150, 150));
        imgPanel.setBorder(BorderFactory.createEtchedBorder());          

        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);   

        gl.setHorizontalGroup(gl.createParallelGroup(CENTER)
                .addGroup(gl.createSequentialGroup()
                        .addGroup(gl.createParallelGroup(TRAILING)
                                .addComponent(heightLbl)
                                .addComponent(side2Lbl))
                        .addGroup(gl.createParallelGroup()
                                .addComponent(field1)
                                .addComponent(field3))
                        .addGroup(gl.createParallelGroup(TRAILING)
                                .addComponent(baseLbl)
                                .addComponent(side3Lbl))
                        .addGroup(gl.createParallelGroup()
                                .addComponent(field2)
                                .addComponent(field4)))
                .addComponent(calcBtn)
                .addComponent(imgPanel)
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                 .addGroup(gl.createParallelGroup(BASELINE)
                        .addComponent(heightLbl)
                        .addComponent(field1)
                        .addComponent(baseLbl)
                        .addComponent(field2))
                .addGroup(gl.createParallelGroup(BASELINE)
                        .addComponent(side2Lbl)
                        .addComponent(field3)
                        .addComponent(side3Lbl)
                        .addComponent(field4))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(calcBtn)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imgPanel)
        );

        pack();
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GroupLayoutTriangle ex = new GroupLayoutTriangle();
                ex.setVisible(true);
            }
        });
    }
}