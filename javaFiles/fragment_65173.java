import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;

public class TestPane {
    private JPanel main_panel;

    public static void main(String[] args) {
        new TestPane();
    }

    public TestPane() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                createGUI();;

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(main_panel);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public void createGUI() {

        main_panel = new JPanel();
        main_panel.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        JLabel label = new JLabel("Band Directory");
        JComboBox band_combobox = new JComboBox();

        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("1"));
        panel1.setBorder(new TitledBorder("Panel1"));
        JPanel panel2 = new JPanel();
        panel2.setBorder(new TitledBorder("Panel2"));
        panel2.add(new JLabel("2"));
        JPanel panel3 = new JPanel();
        panel3.setBorder(new TitledBorder("Panel3"));
        panel3.add(new JLabel("3"));

        JPanel top = new JPanel();
        top.add(label);
        top.add(band_combobox);

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.weightx = 1;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.gridwidth = GridBagConstraints.REMAINDER;
        gc.insets = new Insets(5, 0, 10, 0);
        main_panel.add(top, gc);

        gc.gridwidth = 1;
        gc.weightx = 0.5;
        gc.gridx = 0;
        gc.gridy = 1;
        gc.insets = new Insets(0, 0, 10, 0);
        main_panel.add(panel1, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        gc.insets = new Insets(0, 0, 10, 0);
        main_panel.add(panel2, gc);

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.weightx = 1;
        gc.gridx = 0;
        gc.gridy = 2;
        gc.gridwidth = GridBagConstraints.REMAINDER;
        gc.insets = new Insets(0, 0, 10, 0);
        main_panel.add(panel3, gc);
    }
}