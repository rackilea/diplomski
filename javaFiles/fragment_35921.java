import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MovingArrows extends JFrame implements ActionListener {

    private JButton buttonUp, buttonDown, buttonLeft, buttonRight;
    private int xCircleCentre, yCircleCentre;

    final int xCircleCentreStarting = 250, yCircleCentreStarting = 250;
    final int RADIUS = 20;

    public static void main(String[] args) {

        MovingArrows  frame = new MovingArrows();
        frame.createGUI();
        frame.pack();
        frame.setVisible(true);

    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel btnPanel = new JPanel();
        Container window = getContentPane();
        DrawHere drawHere = new DrawHere();
        drawHere.setPreferredSize(new Dimension(400,400));
        window.add(drawHere);
        window.add(btnPanel, BorderLayout.SOUTH);
        buttonUp = new JButton("Up");
        buttonDown = new JButton("Down");
        buttonLeft = new JButton("Left");
        buttonRight = new JButton("Right");
        btnPanel.add(buttonUp);
        btnPanel.add(buttonDown);
        btnPanel.add(buttonLeft);
        btnPanel.add(buttonRight);
        buttonUp.addActionListener(this);
        buttonDown.addActionListener(this);
        buttonLeft.addActionListener(this);
        buttonRight.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        repaint();
    }

    class DrawHere extends JPanel {

        public DrawHere(){
            setBackground(Color.WHITE);
        }


        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.black);
            g.fillOval(xCircleCentreStarting - RADIUS, yCircleCentreStarting
                    - RADIUS, RADIUS * 2, RADIUS * 2);

        }
    }
}