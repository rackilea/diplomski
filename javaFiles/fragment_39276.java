import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.RenderingHints;
import java.awt.geom.Path2D;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Letter {

    LetterDraw letterDraw = new LetterDraw();

    public Letter() {
        JFrame frame = new JFrame();
        JPanel letterDrawWrapper = new JPanel(new GridBagLayout());
        letterDrawWrapper.add(letterDraw);
        frame.add(letterDrawWrapper);
        frame.add(createColorChooser(), BorderLayout.PAGE_END);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JColorChooser createColorChooser() {
        JColorChooser colorChooser = new JColorChooser();
        colorChooser.getSelectionModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                letterDraw.setColor(colorChooser.getColor());
            }
        });
        return colorChooser;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Letter();
            }
        });
    }
}

class LetterDraw extends JPanel {

    private Color color;

    public void setColor(Color color) {
        this.color = color;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Path2D.Double path = new Path2D.Double();
        Graphics2D g = (Graphics2D) graphics;
        path.moveTo(17, 63);
        /*
         * Top Horizontal Line
         */
        path.curveTo(21, 60, 21, 43, 17, 37); //left vert
        path.curveTo(30, 43, 100, 43, 120, 37); //top horiz
        path.curveTo(115, 45, 115, 57, 117, 62); //right vert
        path.curveTo(105, 53, 60, 57, 17, 63); //bottom horiz right
            /*
         * Bottom Horizontal Line
         */
        path.moveTo(32, 97);
        path.curveTo(37, 85, 35, 79, 35, 77); //left vert
        path.curveTo(45, 79, 45, 79, 100, 79); //top left horiz
        path.curveTo(96, 85, 98, 92, 98, 98);//right vert
        path.curveTo(89, 93, 79, 94, 32, 97);//bottom right horiz
            /*
         * Vertical Line
         */
        path.moveTo(40, 130);
        path.curveTo(48, 110, 46, 70, 37, 55); //left vert
        path.curveTo(62, 55, 62, 55, 60, 55); //top horiz
        path.curveTo(68, 80, 68, 100, 63, 130); //right vert
        path.curveTo(60, 127, 50, 127, 40, 130);//bottom horiz
        g.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setStroke(new BasicStroke(3));
        //g.setStroke(new BasicStroke(4, BasicStroke.JOIN_BEVEL, 0));
        g.draw(path);
        g.setColor(color);
        g.fill(path);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(150, 150);
    }
}