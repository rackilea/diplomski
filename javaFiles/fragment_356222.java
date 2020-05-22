import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import javax.swing.*;

@SuppressWarnings("serial")
public class DrawButtonPanel extends JPanel {
    private static final int SIDE = 3;
    private static final int GAP = 5;
    private static final Color BG = Color.BLACK;

    public DrawButtonPanel() {
        setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
        setLayout(new GridLayout(SIDE, SIDE, GAP, GAP));
        setBackground(BG);
        for (int i = 0; i < SIDE * SIDE; i++) {
            // add(new DrawButton1());
            DrawButton2 drawButton2 = new DrawButton2(i);
            AbstractButton button = drawButton2.getButton();
            add(button);
        }
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new DrawButtonPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}

class DrawButton2 {
    private static final int PREF_W = 200;
    private static final int PREF_H = PREF_W;
    private static final int GAP = 20;
    private static final float STROKE_WIDTH = 15f;
    private static final Stroke BASIC_STROKE = new BasicStroke(STROKE_WIDTH);
    private static final Color COLOR = Color.RED;
    private static final Color BG = Color.LIGHT_GRAY;
    private AbstractButton button = new JToggleButton();
    private int index;

    public DrawButton2(int index) {
        this.index = index;
        button.setBorderPainted(false);
        button.setBorder(null);
        button.setIcon(createPlainIcon());
        button.setSelectedIcon(createSelectedIcon());

        button.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println("Index: " + index);
                }
            }
        });
    }

    public int getIndex() {
        return index;
    }

    private Icon createPlainIcon() {
        BufferedImage img = new BufferedImage(PREF_W, PREF_H, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        g2d.setColor(new Color(0, 0, 0, 0));
        g2d.fillRect(0, 0, PREF_W, PREF_H);
        g2d.dispose();
        return new ImageIcon(img);
    }

    private Icon createSelectedIcon() {
        BufferedImage img = new BufferedImage(PREF_W, PREF_H, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(BASIC_STROKE);
        g2d.setColor(BG);
        g2d.fillRect(0, 0, PREF_W, PREF_H);
        g2d.setColor(COLOR);
        g2d.drawOval(GAP, GAP, PREF_W - 2 * GAP, PREF_H - 2 * GAP);
        g2d.dispose();
        return new ImageIcon(img);
    }

    public AbstractButton getButton() {
        return button;
    }

}

@SuppressWarnings("serial")
class DrawButton1 extends JToggleButton {
    private static final int PREF_W = 200;
    private static final int PREF_H = PREF_W;
    private static final int GAP = 20;
    private static final float STROKE_WIDTH = 15f;
    private static final Stroke BASIC_STROKE = new BasicStroke(STROKE_WIDTH);
    private static final Color COLOR = Color.RED;
    private static final Color BG = Color.LIGHT_GRAY;

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(BASIC_STROKE);
        if (!isSelected()) {
            super.paintComponent(g);
        } else {
            g2d.setColor(BG);
            g2d.fillRect(0, 0, getWidth(), getHeight());
            g2d.setColor(COLOR);
            g2d.drawOval(GAP, GAP, getWidth() - 2 * GAP, getHeight() - 2 * GAP);
        }
        g2d.dispose(); // since we created a new one
    }
}