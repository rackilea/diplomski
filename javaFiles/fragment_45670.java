import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ViewPaper extends JPanel {

    static ViewPaper viewPaper;
    static int line=50;
    public static void main(String args[])
    {
            JFrame frame=new JFrame("View Paper");
            viewPaper=new ViewPaper();
            frame.add(viewPaper);
            JButton button=new JButton("Click Me!");
            frame.add(button,BorderLayout.SOUTH);
            button.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    viewPaper.updateImage(line++);
                }
            });

            frame.setSize(300,500);
            frame.setVisible(true);
    }
    private BufferedImage buffer = null;
    private final int width = 384;
    private int height = 500;

    private final static Logger LOG = Logger.getLogger(ViewPaper.class
            .getName());

    public ViewPaper() {
        super();
        buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        printDotLine(50);
        LOG.log(Level.INFO, "ViewPaper: Load Successful.");
    }


    /* Update BufferedImage then repaint to screen.
     * Note. A Top Level repaint() is also called
     * and according to log the paintComponent is
     * called but nothing is happening! 
     */
    public void updateImage(int y) {
        printDotLine(y);
        repaint();
    }


    /* Update JPanel with updated buffer. */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.drawImage(buffer, 0, 0, this);
        g2d.dispose();
        LOG.log(Level.INFO, "ViewPaper: paintComponent(); Called.");
    }


    /* Sets row of pixels in buffer to black.*/
    public void printDotLine(int y) {
        for (int x = 0; x < width; x++) {
            buffer.setRGB(x, y, Color.BLACK.getRGB());
        }
        LOG.log(Level.INFO, "ViewPaper: Update Received.");
    }

}