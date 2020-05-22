import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class Problematic {

    public static void main(String[] args) {
        JFrame f = new JFrame("frame");
        f.setLayout(new BorderLayout()); 

        JPanel p = new JPanel(new GridLayout(1, 1)); //assign gridlayout so text area fills panel 
        JTextArea t2 = new JTextArea(5, 30);
        t2.setText("this is some random text\nthat may go for many rows\nso it may look messy");

        JScrollPane scrollPane = new JScrollPane(t2);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        p.add(scrollPane);
        f.add(p, BorderLayout.CENTER); //place text area panel in center position 

        JPanel p1 = new JPanel();
        JButton button = new JButton("Whatever here");
        p1.add(button);
        f.add(p1, BorderLayout.PAGE_END);

        f.setSize(600, 500);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}