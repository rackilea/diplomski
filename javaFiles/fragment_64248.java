import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

@SuppressWarnings("serial")
public class Prova2 extends JPanel {
    private static final int ROWS = 6;
    private static final int COLS = 7;
    private static final int LBL_EB = 25; // "eb" for empty border
    private static final int PNL_EB = 3;
    public static final Font BIG = new Font("Comic Sans MS", Font.BOLD, 18);
    private static final Color BACKGROUND = new Color(41, 41, 41);
    private static final String VUOTA = "vuota";
    private JLabel[] lblCircles = new JLabel[ROWS * COLS];
    private Integer[][] tbl = new Integer[ROWS][COLS];
    private int choose = 1, n = 0;

    public Prova2() {
        setBorder(BorderFactory.createEmptyBorder(PNL_EB, PNL_EB, PNL_EB, PNL_EB));
        setLayout(new GridLayout(ROWS, COLS));
        setBackground(BACKGROUND);
        for (int i = 0; i < lblCircles.length; i++) {
            lblCircles[i] = new JLabel("test");
            lblCircles[i].setForeground(Color.RED);
            lblCircles[i].setFont(BIG);
            lblCircles[i].setBorder(BorderFactory.createEmptyBorder(LBL_EB, LBL_EB, LBL_EB, LBL_EB));
            lblCircles[i].setName(VUOTA);
            lblCircles[i].addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    for (int i = 0; i < lblCircles.length; i++) {
                        if (e.getSource() == lblCircles[i] && choose == 1) {
                            myLabelClicked(lblCircles[i], i);
                        }
                    }
                }
            });
            add(lblCircles[i]);
        }
    }

    protected void myLabelClicked(JLabel label, int i) {
        int row = i / COLS;
        int col = i % COLS;
        if (!VUOTA.equals(label.getName())) {
            return;
        }
        if (n == 0) {
            n = 1;
            label.setText("ok1");
            tbl[row][col] = 1;
        } else {
            n = 0;
            label.setText("ok2");
            tbl[row][col] = 2;
        }
        label.setForeground(Color.GREEN);
        label.setName("piena");
        System.out.printf("tbl[%d][%d] = %d%n", row, col, tbl[row][col]);
    }

    private static void createAndShowGui() {
        Prova2 mainPanel = new Prova2();

        JFrame frame = new JFrame("Prova 2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}