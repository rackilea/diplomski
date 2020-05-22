import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MyPanel extends JPanel{

    JButton button1 = new JButton("Button 1");
    JButton button2 = new JButton("Button 2");
    JButton button3 = new JButton("Button 3");
    JButton button4 = new JButton("Button 4");

    public MyPanel() {
        setLayout(new GridLayout(3, 3));
        setSize(512, 512);
        setOpaque(false);
        add(button1);
        add(new JLabel());
        add(button2);
        add(new JLabel());
        add(new JLabel());
        add(new JLabel());
        add(button3);
        add(new JLabel());
        add(button4);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.RED);
        Point p1 = button1.getLocation();
        p1.x += button1.getWidth() / 2;
        p1.y += button1.getHeight() / 2;
        Point p2 = button4.getLocation();
        p2.x += button4.getWidth() / 2;
        p2.y += button4.getHeight() / 2;
        g.drawLine(p1.x, p1.y, p2.x, p2.y);

        Point p3 = button2.getLocation();
        p3.x += button2.getWidth() / 2;
        p3.y += button2.getHeight() / 2;
        Point p4 = button3.getLocation();
        p4.x += button3.getWidth() / 2;
        p4.y += button3.getHeight() / 2;
        g.setColor(Color.BLUE);
        g.drawLine(p3.x, p3.y, p4.x, p4.y);

    }


}