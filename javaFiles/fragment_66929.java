package com.johanw.stackoverflow.hebrewkey;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Test extends JFrame{
    private static Robot robot;

    public static void main(String[] args) {
        try {
            robot = new Robot();
        } catch (AWTException e1) {
            e1.printStackTrace();
        }

        JFrame win = new JFrame();
        win.setSize(200,100);
        JPanel panel = new JPanel();
        JButton button = new JButton("simulate");
        final JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(100, 30));
        panel.add(textField);
        panel.add(button);
        win.add(panel);
        win.setVisible(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.requestFocus();
//                pressUnicode(robot,0X5D4);
                pressUnicode(robot,0X2C);
/*
                robot.keyRelease(0X2C);
                robot.keyRelease(0X2C);
*/
            }
        });


    }

    public static void pressUnicode(Robot r, int key_code)
    {
        r.keyPress(KeyEvent.VK_ALT);

        for(int i = 3; i >= 0; --i)
        {
            // extracts a single decade of the key-code and adds
            // an offset to get the required VK_NUMPAD key-code
            int numpad_kc = key_code / (int) (Math.pow(10, i)) % 10 + KeyEvent.VK_NUMPAD0;

            r.keyPress(numpad_kc);
            r.keyRelease(numpad_kc);
        }

        r.keyRelease(KeyEvent.VK_ALT);
    }
}