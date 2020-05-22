import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ships {

    public static JPanel init(JPanel radioPanel){
        radioPanel.add(addShips(2));
        radioPanel.add(addShips(3));
        radioPanel.add(addShips(4));
        radioPanel.add(addShips(5));

        return radioPanel;
    }

    public static JButton addShips(int size){
        JButton but = new JButton();
        Dimension d = new Dimension((40*size),40);
        but.setPreferredSize(d);
        but.setMinimumSize(d);
        but.setMaximumSize(d);
        but.setBackground(Color.BLACK);
        return but;
    }

    public static void main(String[] args){
        JFrame frame = new JFrame();
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.Y_AXIS)); //line 4
        init(radioPanel);
        frame.getContentPane().add(radioPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}