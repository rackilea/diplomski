import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.util.EnumMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class View {

    private static final int ICON_W = 18;
    public static final String CELL_SELECTION = "cell selection";
    private int rows;

    private JPanel mainPanel;
    private JLabel[][] grid;
    private Map<Token, Icon> iconMap = new EnumMap<>(Token.class);
    private int selectedRow;
    private int selectedCol;

    //a collection of cells representing a path
    private CellsList path;

    View() {

        iconMap.put(Token.VIDE, createIcon(new Color(0, 0, 0, 0)));
        iconMap.put(Token.CERCLE_BLEU, createIcon(Color.BLUE));
        iconMap.put(Token.CERCLE_ROUGE, createIcon(Color.RED));

        mainPanel = new JPanel();
    }

    private Icon createIcon(Color color) {

        BufferedImage img = new BufferedImage(ICON_W, ICON_W, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(color);
        g2.fillOval(1, 1, ICON_W - 2, ICON_W - 2);
        g2.dispose();

        return new ImageIcon(img);
    }

    void createGrid(int rows, int cols) {

        MyMouseListener listener = new MyMouseListener();
        setRows(rows);

        mainPanel.setLayout(new GridLayout(rows, cols, 1, 1));
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        mainPanel.setBackground(Color.BLACK);
        grid = new JLabel[rows][cols];
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                grid[r][c] = new JLabel(iconMap.get(Token.VIDE));
                grid[r][c].addMouseListener(listener);
                grid[r][c].setOpaque(true);
                grid[r][c].setBackground(Color.WHITE);
                mainPanel.add(grid[r][c]);
            }
        }
    }

    int getSelectedRow() {
        return selectedRow;
    }

    int getSelectedCol() {
        return selectedCol;
    }

    void setCell(Token token, int row, int col) {

        grid[row][col].setIcon(iconMap.get(token));
    }

    int getRows() {
        return rows;
    }

    void setRows(int rows) {
        this.rows = rows;
    }

    //added to each cell to listen to mouse clicks
    //fires property change with cell index
    private class MyMouseListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            JLabel selection = (JLabel) e.getSource();
            for (int r = 0; r < grid.length; r++) {
                for (int c = 0; c < grid[r].length; c++) {
                    if (selection == grid[r][c]) {
                        selectedRow = r;
                        selectedCol = c;
                        int index = (r * grid[r].length) + c;
                        mainPanel.firePropertyChange(CELL_SELECTION, -1, index);
                    }
                }
            }
        }
    }

    void start() {

        JFrame frame = new JFrame("MVC Pha");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    //add listener to listen to property changes fired by MyMouseListener
    void addPropertyChangeListener(PropertyChangeListener viewListener) {

        mainPanel.addPropertyChangeListener(viewListener);
    }

    void setPath(CellsList path) {

        this.path = path;
        if(path != null) {
            drawPath();
        }
    }

    //highlight path by changing background color. 
    //It can be changed to draw lines between cells
    private void drawPath() {

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {

                if((path != null) && path.contains(new int[] {r,c})) {
                    grid[r][c].setBackground(Color.YELLOW);
                } else {
                    grid[r][c].setBackground(Color.WHITE);
                }
            }
        }
    }

    void refresh() {

        mainPanel.repaint();
    }
}