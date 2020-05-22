import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BlackjackGame extends JFrame implements ActionListener {
    private JPanel menuPane;
    private JLabel menuTitle;
    private JButton playButton;
    private JButton exitButton;
    private JButton rulesButton;

    private JPanel otherPane;
    private JLabel otherTitle;
    private JButton otherButton;

    public BlackjackGame() {
        mainMenu();
        otherPanel();
        setSize(400, 400);
        setVisible(true);
    }

    private void mainMenu() {

        menuPane = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        menuPane.setBackground(new Color(125,0,0));
        menuPane.setBounds(620,220,175,250);

        menuTitle = new JLabel("Welcome to Blackjack!");
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(0,0,20,0);
        menuPane.add(menuTitle, c);

        playButton = new JButton("Play!");
        playButton.addActionListener(this);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 3;
        c.ipadx = 25;
        c.ipady = 25;
        c.insets = new Insets(0,0,0,0);
        menuPane.add(playButton, c);

        exitButton = new JButton("Exit!");
        exitButton.addActionListener(this);
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 3;
        menuPane.add(exitButton, c);

        rulesButton = new JButton("Set rules.");
        rulesButton.addActionListener(this);
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 3;
        menuPane.add(rulesButton, c);

        add(menuPane);
    }

    private void otherPanel() {
        otherPane = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        otherPane.setBackground(new Color(125,0,0));
        otherPane.setBounds(620,220,175,250);

        otherTitle = new JLabel("Welcome to Second Pane!");
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(0,0,20,0);
        otherPane.add(otherTitle, c);

        otherButton = new JButton("Go Back!");
        otherButton.addActionListener(this);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 3;
        c.ipadx = 25;
        c.ipady = 25;
        c.insets = new Insets(0,0,0,0);
        otherPane.add(otherButton, c);
    }

    public void actionPerformed (ActionEvent event) {
        if(event.getSource() == playButton) {
            remove(menuPane);
            add(otherPane);
            validate();
            repaint();

        } else if(event.getSource() == otherButton) {
            remove(otherPane);
            add(menuPane);
            validate();
            repaint();
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new BlackjackGame());
    }
}