import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Buttons {

    public static void main(String[] args) {
        new Buttons();
    }

    public Buttons() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setLayout(new GridBagLayout());
            add(makeButton());
        }

        public JButton makeButton() {
            Insets An_Inset = new Insets(0, 0, 0, 0);
            String Content = "<Html>"
                            + "  <Table Border=1 Cellspacing=0 Cellpadding=2 Width=48>"
                            + "    <Tr><Td Align=Center BgColor=Blue><Font Size=3>+</Font></Td><Td Align=Center><Font Size=3>+</Font></Td></Tr>"
                            + "    <Tr><Td Align=Center><Font Size=3>+</Font></Td><Td Align=Center>+</Font></Td></Tr>"
                            + "  </Table>"
                            + "</Html>";
            JButton aButton = new JButton(Content);
            aButton.setFont(new Font("Monospaced", 0, 16));
//          aButton.setPreferredSize(new Dimension(56, 56));
            aButton.setEnabled(false);
            aButton.setMargin(An_Inset);
            aButton.setHorizontalAlignment(SwingConstants.CENTER);
            return aButton;
        }

    }

}