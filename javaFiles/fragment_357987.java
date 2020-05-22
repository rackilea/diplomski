import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class TestGraphics {
    private JLayeredPane contentPane;

    public void newImage() {
        try {
            JFileChooser fileChooser = new JFileChooser(".");
            int status = fileChooser.showOpenDialog(null);

            if (status == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                System.out.println("The selected file is from the: " + selectedFile.getParent() + " Drive");
                System.out.println("Name of file: " + selectedFile.getName());
                System.out.println("Opening file");

                BufferedImage buffImage = ImageIO.read(new File(selectedFile.getAbsolutePath()));
                ImageIcon image = new ImageIcon(buffImage);

                contentPane = new JLayeredPane();
                contentPane.setBackground(Color.WHITE);
                contentPane.setOpaque(true);
                // getTabbedPane().setComponentAt(tabNum, contentPane);
                Dimension d = new Dimension(image.getIconWidth(), image.getIconHeight());
                Segmentation segmentation = new Segmentation();
                segmentation.setIcon(image);
                segmentation.setSize(d);
                contentPane.setPreferredSize(d);
                contentPane.add(segmentation);

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(contentPane);
                frame.setResizable(false);
                frame.pack();
                frame.setLocationByPlatform(true);
                frame.setVisible(true);

            } else if (status == JFileChooser.CANCEL_OPTION) {
                JOptionPane.showMessageDialog(null, "Canceled");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class Segmentation extends JLabel {

        private static final long serialVersionUID = -1481861667880271052L; // unique id
        private static final Color LINES_COLOR = Color.red;
        public static final Color CURRENT_LINE_COLOR = new Color(255, 200, 200);
        ArrayList<Line2D> lineList = new ArrayList<Line2D>();
        Line2D currentLine = null;
        MyMouseAdapter mouse = new MyMouseAdapter();

        public Segmentation() {
            addMouseListener(mouse);
            addMouseMotionListener(mouse);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            System.out.println("repainting");

            g2.setColor(LINES_COLOR);
            for (Line2D line : lineList) {
                g2.draw(line);
            }
            if (currentLine != null) {
                g2.setColor(CURRENT_LINE_COLOR);
                g2.draw(currentLine);
            }
        }

        private class MyMouseAdapter extends MouseAdapter {
            Point p1 = null;

            @Override
            public void mousePressed(MouseEvent e) {
                p1 = e.getPoint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (currentLine != null) {
                    currentLine = new Line2D.Double(p1, e.getPoint());
                    lineList.add(currentLine);
                    currentLine = null;
                    p1 = null;
                    System.out.println("about to repaint");
                    repaint();
                }
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                if (p1 != null) {
                    currentLine = new Line2D.Double(p1, e.getPoint());
                    repaint();
                }
            }
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TestGraphics tg = new TestGraphics();
                tg.newImage();
            }
        });
    }

}