import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class OverlayTest2 {

    public static void main(String[] args) {
        new OverlayTest2();
    }

    public OverlayTest2() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                final JFrame masterFrame = new JFrame("Testing");

                final OverlayPane overlay = new OverlayPane();
                JButton show = new JButton("Show");
                show.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        JFrame frame = new JFrame();
                        frame.setUndecorated(true);
                        frame.setBackground(new Color(0, 0, 0, 0));
                        frame.add(new OverlayPane());
                        frame.pack();
                        frame.setLocationRelativeTo(masterFrame);
                        frame.setVisible(true);

                    }
                });

                masterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                masterFrame.setGlassPane(overlay);
                masterFrame.setLayout(new GridBagLayout());
                masterFrame.add(show);
                masterFrame.pack();
                masterFrame.setLocationRelativeTo(null);
                masterFrame.setVisible(true);
            }
        });
    }

    public class OverlayPane extends JPanel {

        private JLabel label;

        public OverlayPane() {
            setLayout(new GridBagLayout());
            label = new JLabel("1");
            label.setFont(label.getFont().deriveFont(Font.BOLD, 96f));
            add(label);
            setOpaque(false);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }

}