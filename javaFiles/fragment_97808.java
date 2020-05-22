import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.AlphaComposite;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

public class ButtonTest {

    private JFrame frame;
    private JPanel panel;
    private JButton opaqueButton1;
    private JButton opaqueButton2;
    private SoftJButton softButton1;
    private SoftJButton softButton2;
    private Timer alphaChanger;

    public void createAndShowGUI() {
        opaqueButton1 = new JButton("Opaque Button");
        opaqueButton2 = new JButton("Opaque Button");
        softButton1 = new SoftJButton("Transparent Button");
        softButton2 = new SoftJButton("Transparent Button");
        opaqueButton1.setBackground(Color.GREEN);
        softButton1.setBackground(Color.GREEN);
        panel = new JPanel();
        panel.setLayout(new java.awt.GridLayout(2, 2, 10, 10));
        panel.add(opaqueButton1);
        panel.add(softButton1);
        panel.add(opaqueButton2);
        panel.add(softButton2);
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        frame = new JFrame();
        frame.add(panel);
        frame.setLocation(150, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        alphaChanger = new Timer(50, new ActionListener() {

            private float incrementer = -.03f;

            @Override
            public void actionPerformed(ActionEvent e) {
                float newAlpha = softButton1.getAlpha() + incrementer;
                if (newAlpha < 0) {
                    newAlpha = 0;
                    incrementer = -incrementer;
                } else if (newAlpha > 1f) {
                    newAlpha = 1f;
                    incrementer = -incrementer;
                }
                softButton1.setAlpha(newAlpha);
                softButton2.setAlpha(newAlpha);
            }
        });
        alphaChanger.start();
        Timer uiChanger = new Timer(3500, new ActionListener() {

            private final LookAndFeelInfo[] laf = UIManager.getInstalledLookAndFeels();
            private int index = 1;

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UIManager.setLookAndFeel(laf[index].getClassName());
                    if (laf[index].getClassName().equals("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel")) {
                        UIManager.getLookAndFeelDefaults().put("Panel.background", Color.orange);
                        SwingUtilities.updateComponentTreeUI(frame);
                    } else {
                        panel.setBackground(Color.yellow);
                        SwingUtilities.updateComponentTreeUI(frame);
                    }
                    opaqueButton1.setText(laf[index].getClassName());
                    softButton1.setText(laf[index].getClassName());
                    frame.pack();
                } catch (Exception exc) {
                    exc.printStackTrace();
                }
                index = (index + 1) % laf.length;
            }
        });
        uiChanger.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new ButtonTest().createAndShowGUI();
            }
        });
    }

    private static class SoftJButton extends JButton {

        private static final JButton lafDeterminer = new JButton();
        private static final long serialVersionUID = 1L;
        private boolean rectangularLAF;
        private float alpha = 1f;

        SoftJButton() {
            this(null, null);
        }

        SoftJButton(String text) {
            this(text, null);
        }

        SoftJButton(String text, Icon icon) {
            super(text, icon);
            setOpaque(false);
            setFocusPainted(false);
        }

        public float getAlpha() {
            return alpha;
        }

        public void setAlpha(float alpha) {
            this.alpha = alpha;
            repaint();
        }

        @Override
        public void paintComponent(java.awt.Graphics g) {
            java.awt.Graphics2D g2 = (java.awt.Graphics2D) g;
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
            if (rectangularLAF && isBackgroundSet()) {
                Color c = getBackground();
                g2.setColor(c);
                g.fillRect(0, 0, getWidth(), getHeight());
            }
            super.paintComponent(g2);
        }

        @Override
        public void updateUI() {
            super.updateUI();
            lafDeterminer.updateUI();
            rectangularLAF = lafDeterminer.isOpaque();
        }
    }
}