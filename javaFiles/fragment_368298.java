package com.sandbox;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SwingSandbox {

    public static void main(String[] args) throws IOException {
        JFrame frame = buildFrame();

        JPanel pane = new JPanel();

        MyActionListener myActionListener = new MyActionListener();

        JButton button1 = new JButton("Button1");
        button1.addActionListener(myActionListener);
        pane.add(button1);
        JButton button2 = new JButton("Button2");
        button2.addActionListener(myActionListener);
        pane.add(button2);


        frame.add(pane);
    }


    private static JFrame buildFrame() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.setVisible(true);
        return frame;
    }


    private static class MyActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            if ("Button1".equals(source.getText())) {
                System.out.println("You clicked button 1");
            } else {
                System.out.println("You clicked button 2");
            }
        }
    }

}