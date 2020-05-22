import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.AbstractBorder;

public class EquationMatrixBorder {

    private JPanel pane;
    private CustomBorder customBorder;
    private static final int ROWS_AND_COLS = 1;

    private void displayGUI() {
        JFrame frame = new JFrame("Custom Border Example");

        customBorder = new CustomBorder(Color.RED, 15, 10);
        pane = new JPanel();

        pane.setLayout(new GridLayout(ROWS_AND_COLS, ROWS_AND_COLS, 15, 15));
        //Used to fill the grid, not relevant to question
        Random random = new Random();
        for (int i = 0; i < ROWS_AND_COLS; i++) {
            for (int j = 0; j < ROWS_AND_COLS; j++) {
                int r = 0;
                if (j % 2 == 0) {
                    r = random.nextInt(2);
                } else {
                    r = random.nextInt(2) - 1;
                }
                pane.add(new JLabel(String.valueOf(r)));
            }
        }

        pane.setBorder(customBorder);
        frame.add(pane);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                new EquationMatrixBorder().displayGUI();
            }
        };
        EventQueue.invokeLater(runnable);
    }
}

class CustomBorder extends AbstractBorder {

    private Color color;
    private int gap;
    private int bracketsTopAndBottom = 10;
    private int internalGap;

    public CustomBorder(Color color, int gap, int internalGap) {
        this.color = color;
        this.gap = gap;
        this.internalGap = internalGap;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        super.paintBorder(c, g, x, y, width, height);
        Graphics2D g2d = null;
        if (g instanceof Graphics2D) {
            g2d = (Graphics2D) g;
            g2d.setColor(color);
            g2d.setStroke(new BasicStroke(3));

            //top part of brackets
            g2d.drawLine(x + gap, y + gap, x + gap + bracketsTopAndBottom, (y +  gap));
            g2d.drawLine(width - x - gap - bracketsTopAndBottom, y + gap, width - gap - x, (y +  gap));

            //bottom part of brackets
            g2d.drawLine(x + gap, height - gap, x + gap + bracketsTopAndBottom, height - gap);
            g2d.drawLine(width - x - gap - bracketsTopAndBottom, height - gap, width - gap - x, height - gap);

            //left and right part of brackets
            g2d.drawLine(x + gap, y + gap, x + gap, height - gap);
            g2d.drawLine(width - x - gap, y + gap, width - x - gap, height - gap);
        }
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return getBorderInsets(c, new Insets(gap, gap, gap, gap));
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        insets.left = insets.top = insets.right = insets.bottom = gap + internalGap;
        return insets;
    }
}