import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main
{
    public static void main(String[] argv)
    {
        JFrame frame = new JFrame("Highlighting");
        frame.setSize(300, 100);

        Label label = new Label();
        label.setText("Money does not buy happiness");
        label.setVerticalAlignment(JLabel.TOP);
        label.highlightRegion(3, 15);

        frame.add(label);
        frame.setVisible(true);
    }

    static class Label extends JLabel
    {
        private static final long serialVersionUID = 1L;
        private int start;
        private int end;

        @Override
        public void paint(Graphics g)
        {
            FontMetrics fontMetrics = g.getFontMetrics();

            String startString = getText().substring(0, start);
            String text = getText().substring(start, end);

            int startX = fontMetrics.stringWidth(startString);
            int startY = 0;

            int length = fontMetrics.stringWidth(text);
            int height = fontMetrics.getHeight();

            g.setColor(new Color(0x33, 0x66, 0xFF, 0x66));
            g.fillRect(startX, startY, length, height);

            super.paint(g);
        }

        public void highlightRegion(int start, int end)
        {
            this.start = start;
            this.end = end;
        }
    }

}