import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game extends JFrame {

    private static final long serialVersionUID = 1L;
    private Board board;

    public Game() {
        super("Game");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.WHITE);

        board = new Board();
        add(board, BorderLayout.CENTER);

        JButton button = new JButton("Start new game");
        button.setFocusPainted(false);

        JPanel control = new JPanel();
        control.setBackground(Color.GREEN);
        control.add(button);
        add(control, BorderLayout.SOUTH);

        pack();
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                new Game();
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency
        SwingUtilities.invokeLater(r);
    }
}

/** A pseudo Cell */
class Cell extends JButton {
    Cell(JComponent parent, int row, int column) {
        super(row + " " + column);
    }
}

/** And this one is the constructor of the class that extends JPanel */
class Board extends JPanel {

    int NUMBER_OF_ROWS=3;
    int NUMBER_OF_COLUMNS=4;
    Cell[][] board;

    public Board() {
        setBackground(Color.RED);
        setLayout(new GridLayout(NUMBER_OF_ROWS, NUMBER_OF_COLUMNS, 5, 5));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 20));
        board = new Cell[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];

        for (int row = 0; row < NUMBER_OF_ROWS; row++) {
            for (int column = 0; column < NUMBER_OF_COLUMNS; column++) {
                board[row][column] = new Cell(this, row, column);
                add(board[row][column]);
            }
        }
    }
}