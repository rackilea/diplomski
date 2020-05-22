import javax.swing.*;
import javax.swing.text.MaskFormatter;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class HangmanGUI {

    private DetailsPanel myPanel;

    public HangmanGUI() throws ParseException {
        myPanel = new DetailsPanel();
        JFrame myframe = new JFrame();

        JPanel content = new JPanel(new BorderLayout());
        content.add(new ImagePane());
        content.add(new GuessPane(), BorderLayout.SOUTH);
        content.setBorder(BorderFactory.createTitledBorder("Hangman Image"));

        myframe.getContentPane().add(content, BorderLayout.CENTER);
        myframe.getContentPane().add(myPanel, BorderLayout.SOUTH);
        myframe.setTitle("Hangman Game");
        myframe.pack();
        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myframe.setLocationRelativeTo(null);
        myframe.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }
                try {
                    new HangmanGUI();
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public class ImagePane extends JPanel {

        private JLabel label;

        public ImagePane() {
            setLayout(new BorderLayout());
            label = new JLabel();
            add(label);
            try {
                label.setIcon(new ImageIcon(ImageIO.read(new URL("http://upload.wikimedia.org/wikipedia/commons/8/8b/Hangman-0.png"))));
            } catch (IOException ex) {
                label.setText("Bad Image");
                ex.printStackTrace();
            }
        }

    }

    public static class GuessPane extends JPanel {

        public GuessPane() {
            MaskFormatter formatter = null;
            try {
                JLabel label = new JLabel("Guesss");
                formatter = new MaskFormatter("? ? ? ? ? ? ?");
                formatter.setPlaceholderCharacter('?');
                JFormattedTextField input = new JFormattedTextField(formatter);
                input.setColumns(20);
                add(label);
                add(input);
            } catch (java.text.ParseException exc) {
                System.err.println("formatter is bad: " + exc.getMessage());
                System.exit(-1);
            }
        }

    }

    public static class DetailsPanel extends JPanel {

        public DetailsPanel() {
            setLayout(new BorderLayout());

            setBorder(BorderFactory.createTitledBorder(" click here "));
            //add(createFormattedPanel(), BorderLayout.PAGE_START);

            JPanel letterPanel = new JPanel(new GridLayout(0, 5));
            for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
                String buttonText = String.valueOf(alphabet);
                JButton letterButton = new JButton(buttonText);
                letterButton.addActionListener(clickedbutton());
                letterPanel.add(letterButton, BorderLayout.CENTER);
            }
            add(letterPanel, BorderLayout.CENTER);
        }

        private ActionListener clickedbutton() {
            return new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String actionCommand = e.getActionCommand();
                    System.out.println("actionCommand is: " + actionCommand);
                }
            };
        }

    }
}