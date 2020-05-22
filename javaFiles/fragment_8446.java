import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class Game {

    private static final String ICON_URL = "http://images2.wikia.nocookie.net/__cb20100515002803/fanon/images/a/a2/Bomberman_sprite.png";

    private static final int GRID_SIZE = 24;
    private static final int SQUARE_SIZE = 30;

    private JFrame frame;

    private Board board;

    private static class Board extends JPanel {

        private int[][] grid;

        private int playerX;
        private int playerY;

        private ImageIcon playerIcon;

        public Board() throws MalformedURLException {
            // Some code to generate a random pseudo-board
            Random random = new Random();
            grid = new int[GRID_SIZE][];
            for (int i = 0; i < GRID_SIZE; i++) {
                grid[i] = new int[GRID_SIZE];
                for (int j = 0; j < GRID_SIZE; j++) {
                    int r = random.nextInt(10);
                    grid[i][j] = r > 8 ? 2 : r > 6 ? 1 : 0;
                }
            }
            playerIcon = new ImageIcon(new URL(ICON_URL));
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(GRID_SIZE * SQUARE_SIZE, GRID_SIZE * SQUARE_SIZE);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // pseudo-board painting
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    switch (grid[i][j]) {
                    case 1:
                        g.setColor(Color.GREEN);
                        g.fillRect(i * SQUARE_SIZE, j * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
                        break;
                    case 2:
                        g.setColor(Color.RED);
                        g.fillRect(i * SQUARE_SIZE, j * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
                        break;

                    default:
                        break;
                    }
                }
            }
            // Player painting
            int x = playerX * SQUARE_SIZE + (SQUARE_SIZE - playerIcon.getIconWidth()) / 2;
            int y = playerY * SQUARE_SIZE + (SQUARE_SIZE - playerIcon.getIconHeight()) / 2;
            g.drawImage(playerIcon.getImage(), x, y, this);
        }

        public int getPlayerX() {
            return playerX;
        }

        public int getPlayerY() {
            return playerY;
        }

        public void setPlayerX(int playerX) {
            if (playerX >= 0 && playerX < GRID_SIZE && grid[playerX][playerY] == 0) {
                this.playerX = playerX;
                repaint();
            }
        }

        public void setPlayerY(int playerY) {
            if (playerY >= 0 && playerY < GRID_SIZE && grid[playerX][playerY] == 0) {
                this.playerY = playerY;
                repaint();
            }
        }
    }

    private class MoveLeftAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            board.setPlayerX(board.getPlayerX() - 1);
        }

    }

    private class MoveRightAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            board.setPlayerX(board.getPlayerX() + 1);
        }

    }

    private class MoveUpAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            board.setPlayerY(board.getPlayerY() - 1);
        }

    }

    private class MoveDownAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            board.setPlayerY(board.getPlayerY() + 1);
        }

    }

    private class ExitAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            int i = JOptionPane.showConfirmDialog(board, "Are you sure you want to exit?");
            if (i == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }

    }

    protected void initUI() throws MalformedURLException {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        board = new Board();
        board.setBackground(Color.BLACK);
        board.registerKeyboardAction(new MoveLeftAction(), KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), JComponent.WHEN_FOCUSED);
        board.registerKeyboardAction(new MoveRightAction(), KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), JComponent.WHEN_FOCUSED);
        board.registerKeyboardAction(new MoveUpAction(), KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), JComponent.WHEN_FOCUSED);
        board.registerKeyboardAction(new MoveDownAction(), KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), JComponent.WHEN_FOCUSED);
        board.registerKeyboardAction(new ExitAction(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
        frame.add(board);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Game().initUI();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Could not load icon from Internet", "Unable to start", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }

}