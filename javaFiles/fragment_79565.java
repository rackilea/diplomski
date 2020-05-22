import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public final class JLabelUpdateDemo {

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                createAndShowGUI();             
            }
        });
    }

    private static void createAndShowGUI(){
        final JFrame frame = new JFrame("Update JLabel Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(JTimerLabel.getInstance());
        frame.setSize(new Dimension(275, 75)); // used for demonstration purposes
        //frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        Timer t = new Timer(1000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int val = Integer.valueOf(JTimerLabel.getInstance().getText());
                JTimerLabel.getInstance().setText(String.valueOf(++val));
            }
        });
        t.start();
    }

    private static final class JTimerLabel extends JLabel{
        private static JTimerLabel INSTANCE;

        private JTimerLabel(){
            super(String.valueOf(0));
            setFont(new Font("Courier New", Font.BOLD,  18));
        }

        public static final JTimerLabel getInstance(){
            if(INSTANCE == null){
                INSTANCE = new JTimerLabel();
            }

            return INSTANCE;
        }
    }
}