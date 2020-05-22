import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Library {

    JFrame frame = new JFrame("Library Management - MENU");
    JButton button1 = new JButton();
    JButton button2 = new JButton();
    JButton button3 = new JButton();
    JButton button4 = new JButton();
    JButton button5 = new JButton();
    JButton button6 = new JButton();
    JButton button7 = new JButton();

    public Library() {

        JPanel cards = new JPanel(new CardLayout());

        JPanel firstPanel = new JPanel();
        JPanel secondPanel = new JPanel();
        JPanel thirdPanel = new JPanel();

        //Init some components...
        JLabel label = new JLabel("MENU");
        button1.setText("ISSUE a BOOK");
        button2.setText("RETURN a BOOK");
        button3.setText("UPDATE/SEARCH RECORD");
        button4.setText("RETURN a BOOK on CARD1");
        button5.setText("RETURN a BOOK on CARD2");
        button6.setText("ISSUE a BOOK on CARD1");
        button7.setText("ISSUE a BOOK on CARD2");

        //First panel setup
        firstPanel.setLayout(new FlowLayout());
        firstPanel.add(label);
        firstPanel.add(button1);
        firstPanel.add(button2);
        firstPanel.add(button3);

        //Second panel setup
        secondPanel.setLayout(new FlowLayout());
        secondPanel.add(button6);
        secondPanel.add(button7);

        //Third panel setup
        thirdPanel.setLayout(new FlowLayout());
        thirdPanel.add(button4);
        thirdPanel.add(button5);

        //Show ISSUE on click of button1 
        button1.addActionListener((ActionEvent e) -> {
            //Change cards to ISSUE panel
            frame.setTitle("ISSUE");
            CardLayout cl = (CardLayout) (cards.getLayout());
            cl.show(cards, "ISSUE");
        });

        //Show RETURN on click of button2
        button2.addActionListener((ActionEvent e) -> {
            frame.setTitle("RETRUN");
            CardLayout cl = (CardLayout) (cards.getLayout());
            cl.show(cards, "RETRUN");

        });

        //Add content to cardlayout JPanel
        cards.add(firstPanel, "MENU");
        cards.add(secondPanel, "ISSUE");
        cards.add(thirdPanel, "RETURN");

        frame.add(cards);

        //Initial card to show...
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, "MENU");

        //Frame constraints
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        Library obj = new Library();
    }

}