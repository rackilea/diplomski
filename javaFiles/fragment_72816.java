import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class PaintProject extends JComponent implements ActionListener {
    public static void main(String[] args) {

        JFrame frame = new JFrame("NEW PAINT PROGRAME!");
        JButton ovalButton = new JButton("Oval");
        ovalButton.setActionCommand("Oval");

        JButton rectangleButton = new JButton("Rectangle");
        rectangleButton.setActionCommand("Rectangle");

        PaintProject paint = new PaintProject();
        ovalButton.addActionListener(paint);
        rectangleButton.addActionListener(paint);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.add(paint);
        frame.add(ovalButton);
        frame.add(rectangleButton);

        frame.pack();
        frame.setVisible(true);

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, 500);

    }

    private void drawOval() {
        Graphics g = this.getGraphics();
        g.setColor(Color.red);
        g.fillOval(0, 0, 100, 100);
    }

    private void drawRectangle() {
        Graphics g = this.getGraphics();
        g.setColor(Color.green);
        g.fillRect(150, 150, 100, 100);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Oval")) {
            drawOval();
        } else if (command.equals("Rectangle")) {
            drawRectangle();
        }

    }

}