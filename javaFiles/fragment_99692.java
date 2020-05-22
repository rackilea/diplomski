import java.awt.Graphics;

import javax.swing.JPanel;

public class PanelWithLine extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(x1,y1,x2,y2);
    }

}