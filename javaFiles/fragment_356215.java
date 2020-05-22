import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class LoopPanelPaint {
    private static final int ROUND_SQR = 0;
    private static final int BALL = 1;

    private List<Color> colorList;

    public LoopPanelPaint() {
        JPanel matrixPanel = new JPanel();
        DrawablePanel[][] drawPanels = createPanelMatrix(matrixPanel);

        colorList = createColorList();

        JButton createImages = createButton(drawPanels);

        JFrame frame = new JFrame();
        frame.add(matrixPanel);
        frame.add(createImages, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public JButton createButton(final DrawablePanel[][] panels) {
        JButton button = new JButton("Create Images");
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                addShapesToPanels(panels);
            }
        });
        return button;
    }

    private DrawablePanel[][] createPanelMatrix(JPanel panel) {
        panel.setLayout(new GridLayout(10, 10));
        DrawablePanel[][] panels = new DrawablePanel[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                DrawablePanel drawPanel = new DrawablePanel();
                panels[i][j] = drawPanel;
                panel.add(drawPanel);
            }
        }
        return panels;
    }

    private void addShapesToPanels(DrawablePanel[][] panels) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int type = random.nextInt(2);
                Drawable drawable = getRandomDrawable(type);
                int colorIndex = random.nextInt(colorList.size());
                Color color = colorList.get(colorIndex);
                panels[i][j].setColor(color);
                panels[i][j].setDrawable(drawable);
            }
        }
    }

    private Drawable getRandomDrawable(int type) {
        switch (type) {
        case ROUND_SQR:
            return new RoundSquare();
        case BALL:
            return new Ball();
        default:
            return null;
        }
    }

    private List<Color> createColorList() {
        List<Color> colors = new ArrayList<>();
        colors.add(Color.blue);
        colors.add(Color.red);
        colors.add(Color.gray);
        colors.add(Color.green);
        colors.add(Color.orange);
        colors.add(Color.magenta);
        colors.add(Color.yellow);
        colors.add(Color.cyan);
        return colors;
    }

    public class DrawablePanel extends JPanel {

        private Drawable drawable;
        private Color color = Color.black;

        public DrawablePanel(Drawable drawable) {
            this.drawable = drawable;
        }

        public DrawablePanel() {

        }

        public void setDrawable(Drawable drawable) {
            this.drawable = drawable;
            repaint();
        }

        public void setColor(Color color) {
            this.color = color;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(color);
            if (drawable != null) {
                drawable.draw(g2);
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(Drawable.SIZE, Drawable.SIZE);
        }
    }

    public class Ball implements Drawable {

        @Override
        public void draw(Graphics g) {
            g.fillOval(0, 0, Drawable.SIZE, Drawable.SIZE);
        }
    }

    public class RoundSquare implements Drawable {

        @Override
        public void draw(Graphics g) {
            g.fillRoundRect(0, 0, Drawable.SIZE, Drawable.SIZE, 10, 10);

        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoopPanelPaint();
            }
        });

    }

}

interface Drawable {
    public static final int SIZE = 50;

    public void draw(Graphics g);
}