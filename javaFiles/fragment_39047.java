package com.sandbox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sandbox {
    public static void main(String[] args) {
        Container pane = //...
        pane.setLayout(new GridLayout(10, 10));
        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 10; c++) {
                JButton button = new JButton();
                button.addActionListener(new PositionAwareActionListener(r, c));
                pane.add(button);
            }
        }
    }

    private static class PositionAwareActionListener implements ActionListener {
        private int r;
        private int c;

        public PositionAwareActionListener(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            //callYourFunction(r, c);
        }
    }


}