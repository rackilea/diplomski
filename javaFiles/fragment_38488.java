package org.apache.people.mclark.examples;
import java.awt.event.*;
import javax.swing.*;

public class ClosingFrame extends JFrame {

    public ClosingFrame() {
        final JFrame frame = this;
        // Setting DO_NOTHING_ON_CLOSE is important, don't forget!
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int response = JOptionPane.showConfirmDialog(frame,
                        "Really Exit?", "Confirm Exit",
                        JOptionPane.OK_CANCEL_OPTION);
                if (response == JOptionPane.OK_OPTION) {
                    frame.dispose(); // close the window
                } else {
                    // else let the window stay open
                }
            }
        });
        frame.setSize(320, 240);
        frame.setLocationRelativeTo(null);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClosingFrame().setVisible(true);
            }
        });
    }
}