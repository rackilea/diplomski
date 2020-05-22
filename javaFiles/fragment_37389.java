import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TicTacToeView extends JFrame {

    private JButton oButton, xButton;
    public JPanel board;
    public ArrayList<Shape> shapes;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new TicTacToeView();
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public TicTacToeView() {
        shapes = new ArrayList<Shape>();
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        add(topPanel, BorderLayout.NORTH);
        add(board = new Board(), BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class Board extends JPanel {

        private Rectangle selectedCell = null;

        public Board() {
    addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int w = getWidth();
            int h = getHeight();
            selectedCell = null;
            for (int col = 0; col < 3 && selectedCell == null; col++) {
                for (int row = 0; row < 3; row++) {
                    int x = (w / 3) * col;
                    int y = (h / 3) * row;
                    Rectangle cell = new Rectangle(x, y, w / 3, h / 3);
                    if (cell.contains(e.getPoint())) {
                        System.out.println("In");
                        selectedCell = cell;
                        repaint();
                        break;
                    }
                }
            }
        }
    });
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            int w = getWidth();
            int h = getHeight();
            Graphics2D g2d = (Graphics2D) g;

            g2d.setPaint(Color.WHITE);
            g2d.fill(new Rectangle2D.Double(0, 0, w, h));

            if (selectedCell != null) {
                g2d.setColor(Color.BLUE);
                g2d.fill(selectedCell);
            }

            g2d.setPaint(Color.BLACK);
            g2d.setStroke(new BasicStroke(4));
            g2d.draw(new Line2D.Double(0, h / 3, w, h / 3));
            g2d.draw(new Line2D.Double(0, h * 2 / 3, w, h * 2 / 3));
            g2d.draw(new Line2D.Double(w / 3, 0, w / 3, h));
            g2d.draw(new Line2D.Double(w * 2 / 3, 0, w * 2 / 3, h));
            //draw circles and xs by visiting elements in the array List.
            for (Shape shape : shapes) {
                g2d.setPaint(Color.BLUE);
                g2d.draw(shape);
            }
        }
    }

}