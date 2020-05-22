package main;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Timer;

class Test {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setPreferredSize(new Dimension(400, 400));
        frame.setSize(400, 400);

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("BOO"));
        panel.add(new JButton("BBBB"));

        JScrollPane contentpane = new JScrollPane(panel);
        frame.add(contentpane);

        new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel newpanel = new JPanel();
                newpanel.add(new JLabel("LOL"));
                panel.add(newpanel);
                System.out.println(100 * panel.getComponents().length);
                panel.setPreferredSize(new Dimension(0, 100 * panel.getComponents().length));
                contentpane.validate();
            }
        }).start();

        frame.setVisible(true);
    }
}