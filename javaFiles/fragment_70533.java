import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainClass {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainClass();
            }
        });
    }

    public MainClass() {

        JFrame frame = new JFrame("JFrame Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea outputarea = new JTextArea();
        outputarea.setBorder(new LineBorder(Color.GRAY));
        outputarea.setWrapStyleWord(true);
        outputarea.setLineWrap(true);
        outputarea.setEditable(false);

        JTextField field = new JTextField();
        field.setBorder(new CompoundBorder(new EmptyBorder(0, 0, 3, 0), field.getBorder()));

        JButton button = new JButton("Enter");
        button.setBackground(Color.LIGHT_GRAY);
        button.setFocusPainted(false);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputarea.setText("You wrote: " + field.getText());
            }
        });

        // This panel is just needed in order to set a border for the button
        // without losing it's margin.
        BorderPanel buttonPanel = new BorderPanel();
        buttonPanel.setBorder(new CompoundBorder(new EmptyBorder(0, 10, 0, 30), new LineBorder(Color.BLACK)));
        buttonPanel.add(button);

        BorderPanel northPanel = new BorderPanel();
        northPanel.add(field);
        northPanel.add(buttonPanel, BorderLayout.EAST);

        BorderPanel mainPanel = new BorderPanel();
        mainPanel.add(outputarea);
        mainPanel.add(northPanel, BorderLayout.NORTH);

        frame.setContentPane(mainPanel);
        frame.setSize(600, 300);
        frame.setVisible(true);

    }

    public class BorderPanel extends JPanel {

        public BorderPanel() {
            setLayout(new BorderLayout());
            setBackground(Color.WHITE);
        }

    }

}