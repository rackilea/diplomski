import javax.swing.*;
import java.awt.*;
import java.util.*;

public class PP6_11
{
    public static void main (String[] args)
    {
        JFrame frame = new JFrame ("Lines");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        LinesPanel panel = new LinesPanel(20, 0.5);
        panel.setPreferredSize (new Dimension (400, 300));

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}

class LinesPanel extends JPanel
{
    private final int numLines;
    private final double colorSplit;
    private final Random generator;

    //-----------------------------------------------------------------------
    // Sets up the drawing panel.
    //-----------------------------------------------------------------------

    public LinesPanel(int numLines, double colorSplit)
    {
        this.numLines = numLines;
        this.colorSplit = colorSplit;

        this.generator = new Random();

        setBackground (Color.black);
    }

    //-----------------------------------------------------------------------
    // Paints evenly spaced Horizontal lines of random length.
    // lines that are half the width are highlighted with a re color.
    //-----------------------------------------------------------------------

    public void paintComponent (Graphics page)
    {
        // Clear the off-screen bitmap and set the background.
        super.paintComponent(page);

        final int pageWidth = getWidth();
        final int pageHeight = getHeight();

        // Calculate the line spacing and center vertically.
        final int lineSpace = (pageHeight - 1) / (numLines - 1);
        final int margin = (pageHeight - (lineSpace * (numLines - 1))) / 2;

            final int splitWidth = (int)(pageWidth * colorSplit);

        for (int y = margin; y < pageHeight; y += lineSpace)
        {
            int width = generator.nextInt(pageWidth) + 1;
            page.setColor(width <= splitWidth ? Color.red : Color.blue);
            page.drawLine(0, y, width, y);
        }
    }
}