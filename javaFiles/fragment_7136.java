import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class GoBoardDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.add(new GoPanel(19), BorderLayout.CENTER);
        frame.setSize(600, 625);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}


@SuppressWarnings("serial")
class GoPanel extends JPanel {

    Square[][] board;
    boolean whiteToMove;

    GoPanel(int dimension) {
        board = new Square[dimension][dimension];
        whiteToMove = true;
        initBoard(dimension);
    }

    private void initBoard(int dimension) {
        super.setLayout(new GridLayout(dimension, dimension));
        for(int row = 0; row < dimension; row++) {
            for(int col = 0; col < dimension; col++) {
                board[row][col] = new Square(row, col);
                super.add(board[row][col]);
            }
        }
        repaint();
    }

    private class Square extends JPanel {

        Stone stone;
        final int row;
        final int col;

        Square(int r, int c) {
            stone = Stone.NONE;
            row = r;
            col = c;
            super.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent me) {
                    if(stone != Stone.NONE) return;
                    stone = whiteToMove ? Stone.WHITE : Stone.BLACK;
                    whiteToMove = !whiteToMove;
                    repaint();
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int w = super.getWidth();
            int h = super.getHeight();
            g.setColor(new Color(0xB78600));
            g.fillRect(0, 0, w, h);
            g.setColor(Color.BLACK);   
            if(row == 0 || row == board.length-1 || col == 0 || col == board.length-1) {
                if(col == 0) {
                    g.drawLine(w/2, h/2, w, h/2);
                    if(row == 0) g.drawLine(w/2, h/2, w/2, h);
                    else if(row == 18) g.drawLine(w/2, h/2, w/2, 0);
                    else g.drawLine(w/2, 0, w/2, h);
                }
                else if(col == 18) {
                    g.drawLine(0, h/2, w/2, h/2);
                    if(row == 0) g.drawLine(w/2, h/2, w/2, h);
                    else if(row == 18) g.drawLine(w/2, h/2, w/2, 0);
                    else g.drawLine(w/2, 0, w/2, h);
                }
                else if(row == 0) {
                    g.drawLine(0, h/2, w, h/2);
                    g.drawLine(w/2, h/2, w/2, h);
                }
                else {
                    g.drawLine(0, h/2, w, h/2);
                    g.drawLine(w/2, h/2, w/2, 0);
                }
            } else {
                g.drawLine(0, h/2, w, h/2);
                g.drawLine(w/2, 0, w/2, h);
            }
            stone.paint(g, w);
        }
    }
}

enum Stone { 

    BLACK(Color.BLACK), WHITE(Color.WHITE), NONE(null);

    final Color color;
    private final static Random rand = new Random();

    private Stone(Color c) {
        color = c;
    }

    public void paint(Graphics g, int dimension) {
        if(this == NONE) return;
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(color);
        int x = 5;
        g2d.fillOval(rand.nextInt(x), rand.nextInt(x), dimension-x, dimension-x);
    }
}