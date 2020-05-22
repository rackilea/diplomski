import static javax.swing.BorderFactory.createEmptyBorder;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;

public class OffsetGrid {
    public static final int ROWS = 10;
    public static final int COLUMNS = 10;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(ROWS, 1));
        final JPanel[] panel = new JPanel[ROWS];
        final JButton[][] button = new JButton[ROWS][COLUMNS];
        for (int row = 0; row < ROWS; row++) {
            panel[row] = new JPanel(new GridLayout(1, COLUMNS));
            for (int y = 0; y < COLUMNS; y++) {
                button[row][y] = new JButton(row + "-" + y);
                button[row][y].setOpaque(true);
                panel[row].add(button[row][y]);
            }
            int padding = button[row][0].getPreferredSize().width / 2;
            if (row % 2 == 0)
                panel[row].setBorder(createEmptyBorder(0, 0, 0, padding));
            else
                panel[row].setBorder(createEmptyBorder(0, padding, 0, 0));
            frame.add(panel[row]);
        }
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                for (int row = 0; row < ROWS; row++) {
                    int padding = button[row][0].getSize().width / 2;
                    panel[row].setBorder(createEmptyBorder(0, 0, 0, padding));
                    if (++row == ROWS)
                        break;
                    padding = button[row][0].getSize().width / 2;
                    panel[row].setBorder(createEmptyBorder(0, padding, 0, 0));
                }
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}