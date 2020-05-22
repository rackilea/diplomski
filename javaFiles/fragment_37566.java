import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GridLayoutTest {
    public void createUI(){
        JFrame frame = new JFrame();

        JPanel topPanel = new TopPanel();
        JPanel buttomPanel = new ButtomPanel();


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(topPanel,BorderLayout.CENTER);
        mainPanel.add(buttomPanel,BorderLayout.SOUTH);
        frame.add(mainPanel,BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        GridLayoutTest test = new GridLayoutTest();
        test.createUI();
    }

    @SuppressWarnings("serial")
    class TopPanel extends JPanel{
        public TopPanel(){
            setLayout(new GridLayout(2, 3));
            ImageIcon icon = new ImageIcon("capture.png");
            JLabel label1 = new JLabel(icon);
            label1.setVisible(false);
            JLabel label2 = new JLabel(icon);
            JLabel label3 = new JLabel(icon);
            label3.setVisible(false);
            JLabel label4 = new JLabel(icon);
            JLabel label5 = new JLabel(icon);
            JLabel label6 = new JLabel(icon);
            add(label1);
            add(label2);
            add(label3);
            add(label4);
            add(label5);
            add(label6);
        }
    }

    @SuppressWarnings("serial")
    class ButtomPanel extends JPanel{
        public ButtomPanel(){
            JButton startButton = new JButton("start");
            JButton stopButton = new JButton("stop");
            JButton recordButton = new JButton("record");

            setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
            add(Box.createHorizontalGlue());
            add(startButton);
            add(Box.createHorizontalStrut(10));
            add(stopButton);
            add(Box.createHorizontalStrut(10));
            add(recordButton);
            add(Box.createHorizontalGlue());
        }
    }
}