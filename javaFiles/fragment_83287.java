import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;

public class MakeItSo {

    public static void main(String[] args) {
        new MakeItSo();
    }

    public MakeItSo() {
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
                frame.add(new MainPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class MainPane extends JPanel {

        public MainPane() {
            setLayout(new GridBagLayout());
            setBorder(new LineBorder(Color.RED));

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            add(new JLabel("Disponible:"), gbc);
            add(new JSeparator(), gbc);
            add(new GridPane());
        }

    }

    public class GridPane extends JPanel {

        public GridPane() {
            setLayout(new GridLayout(2, 2));
            setBorder(new LineBorder(Color.YELLOW));

            add(new DetailPane("Mitramail.zip", "Version: 1.0", "Disponible"));
            add(new DetailPane("Test", "Version: 1.5", "Disponible"));
            add(new DetailPane("Other"));
            add(new DetailPane("Other"));
        }

    }

    protected class DetailPane extends JPanel {

        public DetailPane(String... values) {
            setLayout(new GridBagLayout());
            setBorder(new LineBorder(Color.GREEN));

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            if (values != null && values.length > 0) {
                for (String value : values) {
                    add(new JLabel(value), gbc);
                }
            }
        }

    }

}