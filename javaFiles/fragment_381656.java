import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CoordBoutons extends JFrame {

    CoordBoutons() {
        super("GridLayout");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container contenant = getContentPane();
        contenant.setLayout(new GridLayout(8, 8));

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                contenant.add(new CaseEchiquier(i, j));
            }
        }

        pack();
        setVisible(true);
    }

    class CaseEchiquier extends JPanel {

        private int lin, col;

        CaseEchiquier(int i, int j) {
            lin = i;
            col = j;
            setPreferredSize(new Dimension(80, 75));
            setBackground((i + j) % 2 == 0 ? Color.WHITE : Color.GRAY);
            addMouseListener(new MouseAdapter() {
                private Color background;

                @Override
                public void mousePressed(MouseEvent e) {
                    background = getBackground();
                    setBackground(Color.RED);
                    repaint();
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    setBackground(background);
                }
            });
//            addActionListener(new ActionListener() {
//                public void actionPerformed(ActionEvent evt) {
//                    System.out.println((char) ('a' + col) + "" + (8 - lin));
//
//                }
//            });
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                CoordBoutons coordBoutons = new CoordBoutons();
            }
        });
    }
}