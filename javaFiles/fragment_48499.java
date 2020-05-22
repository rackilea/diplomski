import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class exex extends JFrame {
    private static final long serialVersionUID = 1172300329115978744L;

    final int size = 5; // 5x5 bingo board
    int bingos = 0; // how many bingos?
    JButton[][] btn = new JButton[size][size]; // actual display of btns (bingo
                                                // board)
    char[][] grid = new char[size][size]; // grid to check whether it's bingo or
                                            // not
    int presscount = 1; // how many times ive pressed

    boolean[] rowBingos = new boolean[size];
    boolean[] columnBingos = new boolean[size];
    boolean se, sw;

    exex() {
        setTitle("Bingo for everyone");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(size, size));// basic board setup
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                btn[i][j] = new JButton(Integer.toString(i * 5 + j + 1)); // setting
                                                                            // buttons
                                                                            // 1~25;
                grid[i][j] = 'O'; // make a grid board to check bingos
                btn[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JButton btnR = (JButton) e.getSource();
                        System.out.println(presscount);
                        presscount++;
                        for (int i = 0; i < 5; i++) {
                            for (int j = 0; j < 5; j++) {
                                if (btn[i][j] == btnR) {
                                    int row = i;
                                    int column = j;
                                    grid[row][column] = 'X'; // set pressed
                                                                // button to 'X'
                                                                // char on my
                                                                // grid(2D char
                                                                // array)
                                }
                                System.out.print(grid[i][j]);
                            }
                            System.out.println("");
                        }
                        boolean bingo = isBingo('X'); // check if grid has
                                                        // any bingos, if it
                                                        // does, then set
                                                        // bingo to true.
                        System.out.print(bingo);
                        if (bingo) {
                            bingos++;
                        }
                        System.out.print(bingos);
                        System.out.println("-----------");

                        // Color change when pressed,
                        btnR.setBackground(Color.YELLOW);
                        btnR.setOpaque(true);

                    }
                });
                add(btn[i][j]);
            }
            System.out.println();
        }
        setSize(500, 500);
        setVisible(true);

    }

    public boolean isBingo(char g) {
        if (grid[0][0] == g && grid[1][1] == g
                && grid[2][2] == g && grid[3][3] == g
                && grid[4][4] == g && se != true) { // check for S.E
                                                    // diagonal bingos
            se = true;
            return true;
        } else if (grid[0][4] == g && grid[1][3] == g
                && grid[2][2] == g && grid[3][1] == g
                && grid[4][0] == g && sw != true) { // check for S.W
                                                    // diagonal bingos
            sw = true;
            return true;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (grid[0][j] == g && grid[1][j] == g && grid[2][j] == g
                        && grid[3][j] == g && grid[4][j] == g
                        && columnBingos[j] != true) { // check for
                    // vertical
                    // bingos
                    columnBingos[j] = true;
                    return true;
                } else if (grid[i][0] == g && grid[i][1] == g
                        && grid[i][2] == g && grid[i][3] == g
                        && grid[i][4] == g && rowBingos[i] != true) {// check
                                                                        // for
                                                                        // horizontal
                                                                        // bingos
                    rowBingos[i] = true;
                    return true;
                }
            }
        }
        // if no bingos, remains false
        return false;
    }

    public static void main(String[] args) {
        new exex();

    }
}