import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class DrawShapesGUI {

    private JFrame frame;

    private JRadioButton lineButton;
    private JRadioButton rectButton;
    private JRadioButton ovalButton;
    private JRadioButton arcButton;
    private JRadioButton polygonButton;

    private ButtonGroup group;

    private JPanel pane;
    private CustomShape renderShape;

    private Shape shape;

    private ActionListener listener = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(lineButton)) {
                shape = new Line2D.Double(50, 50, 100, 100);
                renderShape.setShape(shape);
            } else if (e.getSource().equals(rectButton)) {
                shape = new Rectangle2D.Double(50, 50, 100, 100);
                renderShape.setShape(shape);
            } else if (e.getSource().equals(ovalButton)) {
                shape = new Ellipse2D.Double(100, 100, 100, 60);
                renderShape.setShape(shape);
            } else if (e.getSource().equals(arcButton)) {
                shape = new Arc2D.Double(50, 50, 200, 200, 90, 30, Arc2D.OPEN);
                renderShape.setShape(shape);
            } else if (e.getSource().equals(polygonButton)) {
                Polygon poly = new Polygon();
                poly.addPoint(100, 50);
                poly.addPoint(150, 50);
                poly.addPoint(200, 100);
                poly.addPoint(150, 150);
                poly.addPoint(100, 150);
                poly.addPoint(50, 100);
                shape = poly;
                renderShape.setShape(shape);
            } 
        }
    };

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DrawShapesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DrawShapesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DrawShapesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DrawShapesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DrawShapesGUI().createAndShowGUI();
            }
        });
    }

    class CustomShape extends JPanel {
        private Shape shape;

        public Shape getShape() {
            return shape;
        }

        public void setShape(Shape shape) {
            this.shape = shape;
            revalidate();
            repaint();
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();

            if (shape != null) {
                g2d.setColor(Color.RED);
                if (shape instanceof Line2D || shape instanceof Arc2D) {
                    g2d.draw(shape);
                } else {
                    g2d.fill(shape);
                }
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(150, 200);
        }
    }

    public void createAndShowGUI() {
        frame = new JFrame(getClass().getSimpleName());

        lineButton = new JRadioButton("Line");
        rectButton = new JRadioButton("Rectangle");
        ovalButton = new JRadioButton("Oval");
        arcButton = new JRadioButton("Arc");
        polygonButton = new JRadioButton("Polygon");

        lineButton.addActionListener(listener);
        rectButton.addActionListener(listener);
        ovalButton.addActionListener(listener);
        arcButton.addActionListener(listener);
        polygonButton.addActionListener(listener);

        group = new ButtonGroup();

        group.add(lineButton);
        group.add(rectButton);
        group.add(ovalButton);
        group.add(arcButton);
        group.add(polygonButton);

        pane = new JPanel();
        pane.add(lineButton);
        pane.add(rectButton);
        pane.add(ovalButton);
        pane.add(arcButton);
        pane.add(polygonButton);

        renderShape = new CustomShape();

        frame.add(pane, BorderLayout.PAGE_START);
        frame.add(renderShape, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}