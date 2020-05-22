import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class CardLayoutDemo extends JFrame implements ActionListener
{
    JButton next;
    JButton prev;
    JButton[] buttons ;
    JPanel[]  cards;
    JPanel    centerPanel;//Going to add all cards
    JPanel lowerPanel;
    int currentButton = 0;
    public void prepareAndShowGUI() 
    {
        next      = new JButton("Next>>");
        prev      = new JButton("<<Previous");
        buttons   = new JButton[10];
        String[]  cardsName = {"ONE","TWO","THREE","FOUR","FIVE","SIX","SEVEN","EIGHT","NINE","TEN"};
        cards     = new JPanel[10];
        centerPanel= new JPanel();
        lowerPanel = new JPanel();
        centerPanel.setLayout(new CardLayout());
        for (int i = 0; i < buttons.length ; i++ )
        {
            buttons[i] = new JButton(cardsName[i]);
            buttons[i].addActionListener(this);
            buttons[i].setActionCommand("CARDS"+i);
            lowerPanel.add(buttons[i]);
            cards[i] = new JPanel();
            cards[i].setLayout(new BorderLayout());
            cards[i].setBorder(BorderFactory.createTitledBorder("Card "+(i+1)));
            cards[i].add(new JLabel(cardsName[i], SwingUtilities.CENTER));
            centerPanel.add(cards[i], cardsName[i]);
        }
        getContentPane().add(centerPanel);
        getContentPane().add(lowerPanel,BorderLayout.SOUTH);
        getContentPane().add(next,BorderLayout.EAST);
        getContentPane().add(prev,BorderLayout.WEST);
        next.addActionListener(this);
        prev.addActionListener(this);
        prev.setEnabled(false);
        if (buttons.length == 1)
        {
            next.setEnabled(false);
        }
        setSize(700,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent evt) 
    {
        JButton clickedButton = (JButton)evt.getSource();
        String command  = clickedButton.getActionCommand();
        if (command.startsWith("CARDS"))
        {
            CardLayout cl = (CardLayout)(centerPanel.getLayout());
            cl.show(centerPanel, clickedButton.getText());
            currentButton = Integer.parseInt(command.substring("CARDS".length()));
            if (currentButton == 0)
            {
                prev.setEnabled(false);
                if (buttons.length > 1)
                {
                    next.setEnabled(true);
                }
            }
            else if (currentButton == buttons.length - 1)
            {
                next.setEnabled(false);
                if (buttons.length > 1)
                {
                    prev.setEnabled(true);
                }
            }
            else
            {
                if (buttons.length > 1)
                {
                    next.setEnabled(true);
                    prev.setEnabled(true);
                }
            }
        }
        else
        {
            if ("Next>>".equals(clickedButton.getText()))
            {
                buttons[++currentButton].doClick();
                if (currentButton == buttons.length - 1)
                {
                    next.setEnabled(false);
                    prev.requestFocus();
                }
                prev.setEnabled(true);
            }
            else if ("<<Previous".equals(clickedButton.getText()))
            {
                buttons[--currentButton].doClick();
                if (currentButton == 0)
                {
                    prev.setEnabled(false);
                    next.requestFocus();
                }
                next.setEnabled(true);
            }
        }

    }     
    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
                CardLayoutDemo cld = new CardLayoutDemo();
                cld.prepareAndShowGUI();
            }
        });
    }
}