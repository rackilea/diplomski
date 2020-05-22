import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class tuna extends JFrame {
    tuna() {
        super("Title");
        // you need to override the method paintComponent for the main panel
        setContentPane(new JPanel(new FlowLayout()) {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.fillOval(50, 100, 100, 155);
            }
        });
        getContentPane().setBackground(Color.white);
    }

    public static void main(String[] arg) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        tuna obj = new tuna();
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.setSize(500, 500);
        obj.setVisible(true);
    }
}