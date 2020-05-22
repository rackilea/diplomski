import java.awt.event.*;
import java.awt.Color;
import java.awt.AlphaComposite;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

public class ButtonTest {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new ButtonTest().createAndShowGUI();
            }
        });
    }

    private JFrame frame;
    private JButton opaqueButton1;
    private JButton opaqueButton2;
    private SoftJButton softButton1;
    private SoftJButton softButton2;

    public void createAndShowGUI() {
        opaqueButton1 = new JButton("Opaque Button");
        opaqueButton2 = new JButton("Opaque Button");
        softButton1 = new SoftJButton("Transparent Button");
        softButton2 = new SoftJButton("Transparent Button");
        opaqueButton1.setBackground(Color.GREEN);
        softButton1.setBackground(Color.GREEN);
        frame = new JFrame();
        frame.getContentPane().setLayout(new java.awt.GridLayout(2, 2, 10, 10));
        frame.add(opaqueButton1);
        frame.add(softButton1);
        frame.add(opaqueButton2);
        frame.add(softButton2);
        frame.setSize(567, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        Timer alphaChanger = new Timer(30, new ActionListener() {

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

            private LookAndFeelInfo[] laf = UIManager.getInstalledLookAndFeels();
            private int index = 1;

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UIManager.setLookAndFeel(laf[index].getClassName());
                    SwingUtilities.updateComponentTreeUI(frame);
                } catch (Exception exc) {
                    exc.printStackTrace();
                }
                index = (index + 1) % laf.length;
            }
        });
        uiChanger.start();
    }

    public static class SoftJButton extends JButton {
        private static final JButton lafDeterminer = new JButton();
        private static final long serialVersionUID = 1L;
        private boolean rectangularLAF;
        private float alpha = 1f;

        public SoftJButton() {
            this(null, null);
        }

        public SoftJButton(String text) {
            this(text, null);
        }

        public SoftJButton(String text, Icon icon) {
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