import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class FrameTest extends JFrame {

    public FrameTest() {
        setLayout(new FlowLayout());
        setSize(150, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pnl_date = new JPanel();
        JLabel lbl_date = new JLabel("X");
        pnl_date.add(lbl_date);
        add(pnl_date);


        JPanel pnl_activities = new JPanel();
        JLabel lbl_act = new JLabel("Y");
        pnl_activities.add(lbl_act);
        add(pnl_activities);

        setLocationRelativeTo(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new FrameTest().setVisible(true);

            }
        });
    }
}