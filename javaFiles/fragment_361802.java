import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.event.MouseInputAdapter;

public class Drawing extends JPanel {

    private JRadioButton red, yellow, blue, erase;
    private JButton button;
    private Color c;
    private ArrayList<Dot> pointList;
    private int counter = 0;
    private boolean isDrawingMode = true;
    private boolean eraser, isBlue;
    private HashMap test;

    public Drawing() {
        setLayout(new FlowLayout());
        setBackground(Color.white);
        JPanel pane = new JPanel();
        pointList = new ArrayList<Dot>();
        addMouseListener(new MouseTrackerListener());

        red = new JRadioButton("Red");
        yellow = new JRadioButton("Yellow");
        blue = new JRadioButton("Blue");
        erase = new JRadioButton("Erase");
        button = new JButton("Clear Drawing");

        red.addActionListener(new ColorActionListener());
        yellow.addActionListener(new ColorActionListener());
        blue.addActionListener(new ColorActionListener());
        erase.addActionListener(new ColorActionListener());
        button.addActionListener(new ColorActionListener());

        pane.add(red);
        pane.add(yellow);
        pane.add(blue);
        pane.add(erase);
        pane.add(button);
        add(pane);
        pane.setBackground(Color.gray);

        ButtonGroup group = new ButtonGroup();
        group.add(red);
        group.add(yellow);
        group.add(blue);
        group.add(erase);

        setPreferredSize(new Dimension(500, 500));
    }

    public void paintComponent(Graphics pen) {
        super.paintComponent(pen);
        for (int i = 0; i < pointList.size(); i++) {

            Dot p = pointList.get(i);
            p.draw(pen);

        }

    }

    private class MouseTrackerListener extends MouseInputAdapter {

        public void mouseClicked(MouseEvent e) {

            counter++;
            if (counter % 2 != 0) {
                addMouseMotionListener(new MouseTrackerListener());
                isDrawingMode = true;

            } else {
                isDrawingMode = false;
            }

        }

    public void mouseMoved(MouseEvent e) {
        if (isDrawingMode) {
            Point point = e.getPoint();
            pointList.add(new Dot(point, c));

            repaint();
        }
    }
    }

    private class ColorActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == red) {
                c = Color.red;
            } else if (e.getSource() == yellow) {
                c = Color.yellow;
            } else if (e.getSource() == blue) {
                c = Color.blue;
            } else if (e.getSource() == erase) {
                eraser = true;
                c = Color.white;
            } else if (e.getSource() == button) {
                pointList.clear();
            }
            repaint();

        }
    }

    public class Dot {

        private Point p;
        private Color color;

        public Dot(Point p, Color color) {
            this.p = p;
            this.color = color;
        }

        public void draw(Graphics g) {
            g.setColor(color);
            g.drawOval(p.x, p.y, 10, 10);
        }

    }

    public static void main(String[] args) {
        Drawing draw = new Drawing();
        JFrame frame = new JFrame("Draw Something!");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(draw);
        frame.setSize(450, 450);
        frame.setVisible(true);
    }
}