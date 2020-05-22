import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class Rotation2 extends JPanel {

    private static final int PREF_W = 750;
    private static final int PREF_H = PREF_W;
    private BufferedImage image = new BufferedImage(400, 400, BufferedImage.TYPE_INT_ARGB);
    private double theta = 0.0;
    private JSlider slider = new JSlider(0, 360, 0);

    public Rotation2() {
        Graphics2D g2 = (Graphics2D) image.createGraphics();
        g2.setColor(Color.red);
        g2.fillRect(0, 0, image.getWidth(), image.getHeight());
        g2.dispose(); 

        slider.setMajorTickSpacing(90);
        slider.setMinorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                theta = Math.toRadians(slider.getValue());
                revalidate();
                repaint();
            }
        });
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(slider);
        setLayout(new BorderLayout());
        add(bottomPanel, BorderLayout.PAGE_END);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        int x = PREF_W / 2;
        int y = PREF_H / 2;
        g2.rotate(theta, x, y);
        int imgX = (PREF_W - image.getWidth()) / 2;
        int imgY = (PREF_H - image.getHeight()) / 2;
        g2.drawImage(image, imgX, imgY, this);
        g2.dispose();
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("Rotation2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new Rotation2());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}