import java.awt.Graphics;

import javax.swing.JPanel;

public class LetSee extends JPanel {

    public void paintComponent(final Graphics g) {

        super.paintComponent(g);

        int row; // Row number, from 0 to 7
        int col; // Column number, from 0 to 7
        int x, y; // Top-left corner of square

        int maxRows = 5;
        int maxCols = 5;

        int rectWidth = 60;
        int rectHeight = 60;

        int maxDrawWidth = rectWidth * maxCols;
        int maxDrawHeight = rectHeight * maxRows;

        // this is for centering :
        int baseX = (getWidth() - maxDrawWidth) / 2;
        int baseY = (getHeight() - maxDrawHeight) / 2;

        for (row = 0; row < maxRows; row++) {

            for (col = 0; col < maxCols; col++) {
                x = col * rectWidth;
                y = row * rectHeight;
                if ((row % 2) == (col % 2)) {
                    g.drawRect(baseX + x, baseY + y, rectWidth, rectHeight);
                } else {
                    g.drawRect(baseX + x, baseY + y, rectWidth, rectHeight);
                }

            }

        } // end for row

    }
}