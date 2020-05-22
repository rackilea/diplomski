import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new Board(10, 10));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class Board extends JPanel {

        public Cell[][] gameBoard;

        public final int GAME_ROWS;
        public final int GAME_COLUMNS;

        public int rowHeight = 50;
        public int columnWidth = 50;

        public Color selectedColor;

        public Board(int GAME_ROWS, int GAME_COLUMNS) {
            this.GAME_COLUMNS = GAME_COLUMNS;
            this.GAME_ROWS = GAME_ROWS;

            createGameBoard();

            setUpBoardPanel();
        }

        private void createGameBoard() {
            Random random = new Random();
            int cellColor;
            Color[] colors = new Color[]{Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.YELLOW};
            gameBoard = new Cell[GAME_ROWS][GAME_COLUMNS];
            for (int row = 0; row < GAME_ROWS; row++) {
                for (int col = 0; col < GAME_COLUMNS; col++) {
                    cellColor = random.nextInt(colors.length);
                    Cell newCell = new Cell(row, col, rowHeight,
                                    columnWidth, colors[cellColor]);
                    gameBoard[row][col] = newCell;
                }
            }
        }

        private void setUpBoardPanel() {
            setLayout(new GridLayout(GAME_ROWS, GAME_COLUMNS));
            setBorder(new EmptyBorder(20, 10, 0, 0));
            setBackground(Color.RED);

            addBoardPanelComponents();
        }

        private void addBoardPanelComponents() {
            for (int r = 0; r < GAME_ROWS; r++) {
                for (int c = 0; c < GAME_COLUMNS; c++) {
                    add(gameBoard[r][c]);
                }
            }
        }
    }

    public class Cell extends JComponent {

        private int row;
        private int col;

        private int rowHeight;
        private int colWidth;

        private boolean active = false;

        private Color color;

        public Cell(int row, int col, int rowHeight, int colWidth, Color color) {
            this.row = row;
            this.col = col;

            this.rowHeight = rowHeight;
            this.colWidth = colWidth;

            this.color = color;
            setBorder(new LineBorder(Color.BLACK));
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(colWidth, rowHeight);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            paintSquare(g);
        }

        private void paintSquare(Graphics g) {
            g.setColor(color);
            g.fillRoundRect(
                            0,
                            0,
                            getWidth() - 1,
                            getHeight() - 1,
                            10,
                            10);

        }

        public int getCol() {
            return col;
        }

        public int getRow() {
            return row;
        }

        public boolean isActive() {
            return active;
        }

        public void setActive(boolean active) {
            this.active = active;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }
    }

}