import java.awt.Color;
import static java.awt.Color.BLACK;
import static java.awt.Color.BLUE;
import java.awt.Dimension;
import static java.awt.EventQueue.invokeLater;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

public class GridCellCoordinator {

    final static int GRID_PANEL_BORDER_WIDTH = 5,
                    N = 11,
                    CELLSIZE = 40;

    //static final JLayeredPane layer = new JLayeredPane();
    static final JPanel panel = new JPanel();
    static final int SM_CELL_BORDER_WIDTH = 1;
    static LineBorder SMcellBorder = new LineBorder(BLACK, SM_CELL_BORDER_WIDTH);

    static JTextField[][] cells = new JTextField[N][N];

    static JFrame frame = new JFrame();

    public GridCellCoordinator() {
        makeGrid();
    }

    private void makeGrid() {
        JPanel pnlGrid = new JPanel();
        pnlGrid.setLayout(new GridLayout(N, N));
        pnlGrid.setBackground(BLUE);
        pnlGrid.setBorder(BorderFactory.createLineBorder(Color.red, GRID_PANEL_BORDER_WIDTH));
        pnlGrid.setLayout(new GridLayout(N, N));

        MouseListener mouseHandler = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                doMousePressed(e);
            }
        };

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                cells[i][j] = new JTextField() {
                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(20, 20);
                    }
                };
                cells[i][j].setText("X");
                cells[i][j].setPreferredSize(new Dimension(CELLSIZE, CELLSIZE));
                cells[i][j].setHorizontalAlignment(JTextField.CENTER);
                cells[i][j].setFocusTraversalKeysEnabled(false);
                cells[i][j].setBorder(SMcellBorder);
                cells[i][j].addMouseListener(mouseHandler);
                pnlGrid.add(cells[i][j]);
            }
        }
        panel.add(pnlGrid);
        panel.setVisible(true);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public void doMousePressed(MouseEvent e) {
        Point p = e.getPoint();
        System.out.println("Source point = " + p + " within " + e.getComponent());
        p = SwingUtilities.convertPoint(e.getComponent(), p, e.getComponent().getParent());
        System.out.println("Converted point = " + p + " within " + e.getComponent().getParent());
    }

    public static void main(String[] args) {
        invokeLater(new Runnable() {
            public void run() {
                new GridCellCoordinator();
            }
        });
    }

}