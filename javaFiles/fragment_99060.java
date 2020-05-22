import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TranslatorFrame {

    public static void main(String[] args) {

        JFrame Words = new JFrame("Greetings Translator");
        Words.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Did some research to find the line so the program
        // would appear in the center of the screen

        Font Font1 = new Font("SansSerif", Font.BOLD, 40);
        JPanel WorkSpace = new JPanel();
        JTextField Instructions = new JTextField("Enter \"Hello\" Here: ");
        JTextField Input = new JTextField();
        JPanel Center = new JPanel();
        Center.setBackground(Color.lightGray);
        Center.add(Instructions, BorderLayout.EAST);
        Center.add(Input, BorderLayout.WEST);
        final JTextField Output = new JTextField("");
        Output.setFont(Font1);
        Output.setPreferredSize(new Dimension(195, 100));
        JTextField Header = new JTextField();
        Header.setPreferredSize(new Dimension(195, 100));
        Input.setPreferredSize(new Dimension(150, 50));
        Input.setFont(Font1);
        Instructions.setPreferredSize(new Dimension(375, 50));
        Instructions.setBackground(Color.cyan);
        // set the back ground color of my Instructions field so that it
        // wouldn't
        // look so gray and boring. There don't seem to be many preset colors to
        // choose from.
        Instructions.setFont(Font1);
        Instructions.setEditable(false);
        JPanel ButtonsArea = new JPanel();
        ButtonsArea.setBackground(Color.lightGray);
        ButtonsArea.setPreferredSize(new Dimension(300, 300));
        final JButton French = new JButton("French");
        French.setPreferredSize(new Dimension(200, 150));
        French.setFont(Font1);
        French.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (arg0.getSource() == French)
                    ;
                Output.setText("Bonjour!");

            }
        });

        JButton German = new JButton("German");
        German.setPreferredSize(new Dimension(200, 150));
        German.setFont(Font1);
        JButton Spanish = new JButton("Spanish");
        Spanish.setPreferredSize(new Dimension(200, 150));
        Spanish.setFont(Font1);
        ButtonsArea.add(French, BorderLayout.EAST);
        ButtonsArea.add(German, BorderLayout.CENTER);
        ButtonsArea.add(Spanish, BorderLayout.WEST);
        ButtonsArea.add(Output, BorderLayout.SOUTH);
        // Tried many different things to get the buttons and textfields
        // to have space between them but nothing seems to work.

        // Header.setSize(100,100);
        Header.setFont(Font1);
        Header.setText("Welcome!");
        Header.setEditable(false);
        WorkSpace.setBackground(Color.LIGHT_GRAY);

        Words.pack();
        Words.setSize(new Dimension(1000, 600));
        Words.setLocationRelativeTo(null);
        WorkSpace.add(Header);
        Words.add(WorkSpace, BorderLayout.NORTH);
        Words.add(Center, BorderLayout.CENTER);
        /*
         * Words.add(Instructions, BorderLayout.CENTER); Words.add(Input,
         * BorderLayout.CENTER);
         */
        Words.add(ButtonsArea, BorderLayout.SOUTH);
        // Words.add(Output, BorderLayout.SOUTH);
        Words.setVisible(true);
    }

}