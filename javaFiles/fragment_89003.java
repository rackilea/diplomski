import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TextStroke {

    public static void main(String[] args) {
        new TextStroke();
    }

    public TextStroke() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            Font font = getFont();
            setFont(font.deriveFont(Font.PLAIN, 80));
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(800, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            int width = getWidth();
            int height = getHeight();

            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
                    RenderingHints.VALUE_RENDER_QUALITY);

            FontRenderContext frc = g2d.getFontRenderContext();
            String s = "Look ma, I'm Stroked";
            TextLayout textTl = new TextLayout(s, getFont(), frc);
            Shape outline = textTl.getOutline(null);

            FontMetrics fm = g2d.getFontMetrics(getFont());
            int x = (getWidth() - outline.getBounds().width) / 2;
            int y = ((getHeight() - outline.getBounds().height) / 2) + fm.getAscent();
            g2d.translate(x, y);

//            Stroke stroke = g2d.getStroke();
            g2d.setColor(Color.BLACK);
            g2d.fill(outline);
            g2d.setStroke(new BasicStroke(5));
            g2d.setColor(Color.RED);
            g2d.draw(outline);
            g2d.dispose();
        }
    }

}