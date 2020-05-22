import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestGridBagLayout {

    public static void main(String[] args) {
        new TestGridBagLayout();
    }

    private JPanel mainPanel;
    private JPanel p1;
    private JPanel p2;
    private JPanel p3;

    public TestGridBagLayout() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                mainPanel = new JPanel();
                mainPanel.setLayout(new GridBagLayout());
                GridBagConstraints c = new GridBagConstraints();

                //P1    FILL P1 WITH 64 BUTTONS
                p1 = new JPanel();
                p1.setLayout(new GridLayout(8, 8));

                p1.setMinimumSize(new Dimension(600, 600));
                p1.setMaximumSize(new Dimension(600, 600));
                p1.setPreferredSize(new Dimension(600, 600));

                for (int y = 0; y < 8; y++) {
                    for (int x = 0; x < 8; x++) {
                        JButton btn = new JButton(x + " , " + y);
                        p1.add(btn);
                    }
                }

                //P2    FILL P2 WITH 4 BUTTONS
                p2 = new JPanel();
                p2.setLayout(new GridLayout(4, 1));
                p2.setMinimumSize(new Dimension(150, 100));
                p2.setMaximumSize(new Dimension(150, 100));
                p2.setPreferredSize(new Dimension(150, 100));

                for (int i = 0; i < 4; i++) {
                    p2.add(new JButton("Button"));
                }

                //P3
                p3 = new JPanel();
                p3.setMinimumSize(new Dimension(100, 150));
                p3.setMaximumSize(new Dimension(100, 150));
                p3.setPreferredSize(new Dimension(100, 150));
                p3.setBackground(Color.BLUE);

                //ADD ALL TO mainPanel
                c.gridx = 0;
                c.gridy = 0;
                c.fill = GridBagConstraints.BOTH;
                c.weightx = 1;
                c.weighty = 1;
                mainPanel.add(p1, c);

                c.gridx = 1;
                c.gridheight = 2;
                c.weighty = 1;
                c.weightx = 0;
                c.fill = GridBagConstraints.VERTICAL;
                mainPanel.add(p2, c);

                c.gridx = 0;
                c.gridy = 1;
                c.gridheight = 1;
                c.gridwidth = 2;
                c.fill = GridBagConstraints.HORIZONTAL;
                c.weighty = 0;
                c.weightx = 1;
                mainPanel.add(p3, c);

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(mainPanel);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

}