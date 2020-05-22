import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.Paint;
import java.awt.RenderingHints;
import javax.swing.*;

@SuppressWarnings("serial")
public class GradientText extends JPanel {
    private static final int PREF_W = 360;
    private static final int PREF_H = 200;
    private static final Font FONT = new Font(Font.DIALOG, Font.BOLD, 46);
    private static final String TEXT = "This is my text";
    private static final int COLOR_COUNT = 30;
    private static final Color BG = Color.BLACK;
    private Paint myPaint;

    public GradientText() {
        setBackground(BG);
        setPreferredSize(new Dimension(PREF_W, PREF_H));
        float[] fractions = new float[COLOR_COUNT];
        Color[] colors = new Color[COLOR_COUNT];
        for (int i = 0; i < colors.length; i++) {
            fractions[i] = ((float)i) / COLOR_COUNT;
            float hue = fractions[i];
            colors[i] = Color.getHSBColor(hue, 1f, 1f);
        }
        myPaint = new LinearGradientPaint(0, 0, PREF_W, 0, fractions, colors);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setPaint(myPaint);
        g2.setFont(FONT);
        g2.drawString(TEXT, 20, 100);
    }

    private static void createAndShowGui() {
        GradientText mainPanel = new GradientText();

        JFrame frame = new JFrame("GradientText");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}