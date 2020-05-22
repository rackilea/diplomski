import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class GBLDemo {

    private JComponent ui = null;

    GBLDemo() {
        initUI();
    }

    private Container getContentPanel() {
        Container contentPane = new JPanel(new BorderLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        JPanel gb = new JPanel(new GridBagLayout());
        contentPane.add(gb);

        gbc.gridx = gbc.gridy = 0;
        gb.add(new JLabel("Look "), gbc);

        gbc.gridx = 1;
        gb.add(new JLabel("at"), gbc);         

        gbc.gridx = 0;
        gbc.gridy = 1;
        gb.add(new JLabel("the "), gbc);

        gbc.gridx = 1;
        gb.add(new JLabel("border"), gbc);

        gb.setBorder(BorderFactory.createTitledBorder("Border"));
        return contentPane;
    }

    public void initUI() {
        if (ui!=null) return;

        // A single object added to a grid bag layout with no constraint, 
        // will be centered within the available space.
        ui = new JPanel(new GridBagLayout()); 
        ui.setBorder(new EmptyBorder(4,4,4,4));

        ui.add(getContentPanel());
    }

    public JComponent getUI() {
        return ui;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception useDefault) {
                }
                GBLDemo o = new GBLDemo();

                JFrame f = new JFrame(o.getClass().getSimpleName());
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);

                f.setContentPane(o.getUI());
                f.pack();
                f.setMinimumSize(f.getSize());

                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}