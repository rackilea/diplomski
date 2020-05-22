import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class VerticalScrollPane {

    public static void main(String[] args) {        
        JPanel panel = new JPanel(null);
        panel.setBorder(BorderFactory.createLineBorder(Color.red));
        panel.setPreferredSize(new Dimension(800, 800));
        panel.setVisible(true);

        JLabel l = new JLabel("test1");
        l.setBounds(40,40,100,100); panel.add(l);
        JLabel l2 = new JLabel("test2");
        l2.setBounds(440,440,100,100);panel.add(l2);

        JScrollPane scroll = new JScrollPane(panel);        
        scroll.getViewport().setViewPosition(new Point(500,350)); //  Use this

        JFrame frame = new JFrame();
        frame.getContentPane().add(scroll);
        frame.setVisible(true); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(scroll, BorderLayout.CENTER);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}