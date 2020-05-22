import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class TransparentPane extends JPanel {

    public TransparentPane() {

        setOpaque(false);

    }

    @Override
    protected void paintComponent(Graphics g) {


        super.paintComponent(g);


        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0f));

        g2d.setColor(getBackground());
        g2d.fill(getBounds());

        g2d.dispose();

    }

}