import java.awt.*;
import javax.swing.*;

public class FontTestWithJapaneseCharacters {

    private JComponent ui = null;

    class PaintingSurface extends JPanel {

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 20);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
            g2d.drawString("Berryz工房 『ROCKエロティック』"
                    + "(Berryz Kobo[Erotic ROCK]) （MV）", 10, 15);
        }
    }

    FontTestWithJapaneseCharacters() {
        initUI();
    }

    public void initUI() {
        if (ui != null) {
            return;
        }

        ui = new PaintingSurface();
    }

    public JComponent getUI() {
        return ui;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(
                            UIManager.getSystemLookAndFeelClassName());
                } catch (Exception useDefault) {
                }
                FontTestWithJapaneseCharacters o
                        = new FontTestWithJapaneseCharacters();

                JFrame f = new JFrame("Font test with Japanese characters");
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);

                f.setContentPane(o.getUI());
                f.pack();
                f.setMinimumSize(f.getSize());

                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}