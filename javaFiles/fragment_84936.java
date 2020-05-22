import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class DrawShapes {

    public static void main(String[] args) {
        new DrawShapes();
    }

    public DrawShapes() {
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
                frame.add(new DrawPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class DrawPane extends JPanel {

        public DrawPane() {

            setLayout(new BorderLayout());

            RenderPane rp = new RenderPane();
            add(new ControlsPane(rp), BorderLayout.NORTH);
            add(rp);

        }

    }

    public class ControlsPane extends JPanel {

        public ControlsPane(RenderPane rp) {

            JRadioButton[] btns = new JRadioButton[4];
            btns[0] = new JRadioButton(new LineAction(rp));
            btns[1] = new JRadioButton(new RectangleAction(rp));
            btns[2] = new JRadioButton(new OvalAction(rp));
            btns[3] = new JRadioButton(new ClearAction(rp));

            ButtonGroup bg = new ButtonGroup();
            for (JRadioButton btn : btns) {
                bg.add(btn);
                add(btn);
            }

        }

    }

    public class RenderPane extends JPanel {

        private Shape shape;

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }

        public void setShape(Shape shape) {
            this.shape = shape;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            if (shape != null) {
                g2d.setColor(Color.RED);
                g2d.draw(shape);
            }
            g2d.dispose();
        }

    }

    public class LineAction extends AbstractRenderAction {

        public LineAction(RenderPane renderPane) {
            super(renderPane);
            putValue(NAME, "Line");
        }

        @Override
        public Shape getShape() {
            return new Line2D.Float(0f, 0f, getRenderPane().getWidth(), getRenderPane().getHeight());
        }

    }

    public class RectangleAction extends AbstractRenderAction {

        public RectangleAction(RenderPane renderPane) {
            super(renderPane);
            putValue(NAME, "Rectangle");
        }

        @Override
        public Shape getShape() {
            return new Rectangle2D.Float(10, 10, getRenderPane().getWidth() - 20, getRenderPane().getHeight() - 20);
        }

    }

    public class OvalAction extends AbstractRenderAction {

        public OvalAction(RenderPane renderPane) {
            super(renderPane);
            putValue(NAME, "Oval");
        }

        @Override
        public Shape getShape() {
            float radius = Math.min(getRenderPane().getWidth() - 20, getRenderPane().getHeight() - 20);
            return new Ellipse2D.Float(10, 10, radius, radius);
        }

    }

    public class ClearAction extends AbstractRenderAction {

        public ClearAction(RenderPane renderPane) {
            super(renderPane);
            putValue(NAME, "Clear");
        }

        @Override
        public Shape getShape() {
            return null;
        }

    }

    public abstract class AbstractRenderAction extends AbstractAction {

        private RenderPane renderPane;

        public AbstractRenderAction(RenderPane renderPane) {
            this.renderPane = renderPane;
        }

        public RenderPane getRenderPane() {
            return renderPane;
        }

        public abstract Shape getShape();

        @Override
        public void actionPerformed(ActionEvent e) {
            getRenderPane().setShape(getShape());
        }

    }

}