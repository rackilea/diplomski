import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
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
                frame.add(new HeaderPane(), BorderLayout.NORTH);
                frame.add(new JPanel() { 
                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(600, 200);
                    }                   
                });
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class HeaderPane extends JPanel {

        public HeaderPane() {
            setLayout(new GridBagLayout());

            add(new JButton("Tab 1"));
            add(new JButton("Tab 2"));

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.weightx = 1;
            gbc.anchor = GridBagConstraints.BASELINE_TRAILING;

            add(new JButton("Minimize"), gbc);
            add(new JButton("Maximise"));
            add(new JButton("Close"));          
        }

    }

}