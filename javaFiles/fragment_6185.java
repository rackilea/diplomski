import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class View extends JFrame {

    public View() {
        this.setPreferredSize(new Dimension(600, 600));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(Color.BLUE));
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        Border border = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.RED, Color.BLACK);

        JPanel p1 = new JPanel() {
            public Dimension getMaximumSize() {
                return new Dimension(200, 400);
            }
        };
        p1.setBorder(border);
        p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));

        panel.add(p1);

        this.add(panel);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new View();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}