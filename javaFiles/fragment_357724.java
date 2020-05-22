import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Main {

    private static JFrame frame = new MyFrame();
    private static JPanel wkp = new JPanel();
    private static JPanel panel = new JPanel();
    private static JPanel table = new JPanel();
    private static JLayeredPane lpane = new JLayeredPane();

    public static void main(String[] args) throws InterruptedException {

        EventQueue.invokeLater(new Runnable() {
            public void run() {

                wkp.setBackground(Color.YELLOW);
                panel.setBackground(Color.GREEN);
                table.setBackground(Color.BLUE);

                frame.setLayout(new BorderLayout());
                frame.add(lpane, BorderLayout.CENTER);
                wkp.setOpaque(true);
                table.setOpaque(true);
                panel.setOpaque(true);
                lpane.add(wkp, new Integer(3), 0);
                lpane.add(panel, new Integer(2), 0);
                lpane.add(table, new Integer(1), 0);
                wkp.setBounds(0, 0, 100, 100);
                panel.setBounds(50, 50, 100, 100);
                table.setBounds(100, 100, 100, 100);
                frame.setTitle("ImageTest");
                frame.setBackground(Color.BLACK);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(lpane);
                //frame.add(wkp);
                //frame.add(table);
                //frame.add(lpane);
                frame.pack();
                frame.setVisible(true);

            }
        });
    }
}