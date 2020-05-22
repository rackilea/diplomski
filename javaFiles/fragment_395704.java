import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFrameTest extends JFrame {

        private JButton testButton;
        private JPanel panelMain;
        private JPanelOne panel;

        public JFrameTest() {

                // setting up JFrame
                setLayout(null);
                setPreferredSize(new Dimension(420, 90));
                setResizable(false);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // creating main JPanel (white)
                panelMain = new JPanel();
                panelMain.setBackground(Color.WHITE);
                panelMain.setBounds(0, 0, 420, 90);
                panelMain.setPreferredSize(new Dimension(200, 40));
                add(panelMain);

                // creating JButton in the main JPanel (white)
                testButton = new JButton("Button from main class");
                panelMain.add(testButton);

                // creating new JPanelOne object from JPanelOne class containing black JPanel
                panel = new JPanelOne();

                // adding black JPanel to main JPanel (white)
                panelMain.add(panel);

                pack();

        }

        public static void main(String[] arguments) {

                // creating JFrame object and setting it visible
                JFrameTest frame = new JFrameTest();
                frame.setVisible(true);

        }

}