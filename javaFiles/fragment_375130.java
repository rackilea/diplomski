import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class PartialPanel extends JPanel {
    private static final int PREF_W = 800;
    private static final int PREF_H = 650;
    private static final int CIRC_W = 200;
    private int circleX = 300;
    private int circleY = 200;
    private Color circleColor = null;
    private ButtonGroup buttonGroup = new ButtonGroup();
    private JRadioButton blueButton = new JRadioButton("Blue");
    private JRadioButton redButton = new JRadioButton("Red");

    public PartialPanel() {
        ColorListener colorListener = new ColorListener();
        blueButton.addActionListener(colorListener);
        redButton.addActionListener(colorListener);

        buttonGroup.add(blueButton);
        buttonGroup.add(redButton);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(blueButton);
        buttonPanel.add(redButton);

        add(buttonPanel);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (circleColor != null) {
            g.setColor(circleColor);
            g.fillOval(circleX, circleY, CIRC_W, CIRC_W);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        } else {
            return new Dimension(PREF_W, PREF_H);
        }
    }

    private class ColorListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == blueButton) {
                circleColor = Color.BLUE;
            } else if (e.getSource() == redButton) {
                circleColor = Color.RED;
            }
            repaint();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }

    private static void createAndShowGui() {
        PartialPanel mainPanel = new PartialPanel();
        JFrame frame = new JFrame("PartialPanel");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}