import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class VerticalLayoutExample {

    public static void main(String[] args) {
        new VerticalLayoutExample();
    }

    public VerticalLayoutExample() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                final TestPane pane = new TestPane();
                JButton add = new JButton("Add");
                add.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        pane.addAnotherPane();
                    }
                });

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new JScrollPane(pane));
                frame.add(add, BorderLayout.SOUTH);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private JPanel filler;
        private int y = 0;

        public TestPane() {

            setBackground(Color.RED);
            setLayout(new GridBagLayout());

            filler = new JPanel();
            filler.setOpaque(false);
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.weighty = 1;
            gbc.gridy = 0;

            add(filler, gbc);

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 400);
        }

        public void addAnotherPane() {

            JPanel panel = new JPanel(new GridBagLayout());
            panel.add(new JLabel("Hello"));

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridy = y++;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.insets = new Insets(4, 4, 4, 4);

            add(panel, gbc);

            GridBagLayout gbl = ((GridBagLayout)getLayout());
            gbc = gbl.getConstraints(filler);
            gbc.gridy = y++;
            gbl.setConstraints(filler, gbc);

            revalidate();
            repaint();

        }           
    }        
}