import javax.swing.*;
import java.awt.*;

class Scratch {

    public static void main(String[] args) throws InterruptedException {
        JFrame jFrame = new JFrame();

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(600, 400);
        jFrame.setVisible(true);

        for (int i = 5; i < 10; ++i) {
            jFrame.setContentPane(createPanel(i, i, new int[i][i]));
            jFrame.revalidate();
            Thread.sleep(1000);
        }
    }

    public static JPanel createPanel(int n, int m, int[][] mat) {
        JButton[] buttons = new JButton[n * m];
        JPanel jPanel = new JPanel();

        jPanel.setLayout(new GridLayout(n, m));

        for (int i = 0; i < n * m; i++) {
            buttons[i] = new JButton();
        }
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < m; k++) {
                int index = k + k * j;

                if (mat[j][k] == 0) {
                    buttons[index].setBackground(Color.BLACK);
                }
                jPanel.add(buttons[index]);
            }
        }

        return jPanel;
    }
}