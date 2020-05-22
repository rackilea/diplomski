import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class CirclePainter implements MouseMotionListener, ActionListener {
    private JFrame mainFrame;
    private JPanel colorPanel, circlePanel;
    private JButton whiteColorButton, redColorButton, greenColorButton,
            blueColorButton;

    private int circleWidth = 3, circleHeight = 15;
    private Color circleColor = Color.black;

    public CirclePainter() {
        initGui();
    }

    public void initGui() {
        mainFrame = new JFrame("Circle");
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(500, 400);

        colorPanel = new JPanel(new FlowLayout());

        whiteColorButton = new JButton();
        whiteColorButton.setBackground(Color.white);
        whiteColorButton.setActionCommand("white");
        whiteColorButton.addActionListener(this);
        redColorButton = new JButton();
        redColorButton.setBackground(Color.red);
        redColorButton.setActionCommand("red");
        redColorButton.addActionListener(this);
        greenColorButton = new JButton();
        greenColorButton.setBackground(Color.green);
        greenColorButton.setActionCommand("green");
        greenColorButton.addActionListener(this);
        blueColorButton = new JButton();
        blueColorButton.setBackground(Color.blue);
        blueColorButton.setActionCommand("blue");
        blueColorButton.addActionListener(this);

        colorPanel.add(whiteColorButton);
        colorPanel.add(redColorButton);
        colorPanel.add(greenColorButton);
        colorPanel.add(blueColorButton);

        circlePanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(circleColor);
                g.fillOval(circleWidth, circleHeight, 50, 50);
            }
        };
        circlePanel.addMouseMotionListener(this);
        circlePanel.setBackground(Color.yellow);
        mainFrame.add(circlePanel, BorderLayout.CENTER);

        mainFrame.add(colorPanel, BorderLayout.PAGE_END);
        mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
        case "white":
            circleColor = Color.white;
            circlePanel.repaint();
            break;
        case "red":
            circleColor = Color.red;
            circlePanel.repaint();
            break;
        case "green":
            circleColor = Color.green;
            circlePanel.repaint();
            break;
        case "blue":
            circleColor = Color.blue;
            circlePanel.repaint();
            break;
        default:
            break;
        }
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CirclePainter();
            }
        });

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if ((e.getX() >= 0 && e.getY() >= 0)
                && (e.getX() <= mainFrame.getWidth() - 60)
                && (e.getY() <= mainFrame.getHeight() - 110)) {
            circleWidth = e.getX();
            circleHeight = e.getY();
            circlePanel.repaint();
        }

    }

    @Override
    public void mouseMoved(MouseEvent arg0) {

    }

}