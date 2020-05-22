import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.border.*;

public class ThreePanelLayout {

    private JComponent ui = null;
    private String[] buttonNames = {"Time", "Price", "Route", "Sort", "Admin", "End"};
    private String[][] comboFirstNames = {{"Departing Stop"}, {"Final Stop"}};

    ThreePanelLayout() {
        initUI();
    }

    public void initUI() {
        if (ui!=null) return;

        // I always use this 'ui' panel as a content pane that contains
        // everything else..
        ui = new JPanel(new BorderLayout(4,4));
        ui.setBorder(new EmptyBorder(4,4,4,4));

        // now to create the 3 panels of the '3 panel layout'. 
        JPanel panel1 = new JPanel(new BorderLayout());
        panel1.setBackground(Color.RED);
        panel1.setBorder(new TitledBorder("Choose Option"));

        JPanel panel2 = new JPanel(new BorderLayout());
        panel2.setBackground(Color.GREEN);
        panel2.setBorder(new TitledBorder("Choose Two Stops"));

        JPanel panel3 = new JPanel(new BorderLayout());
        panel3.setBackground(Color.ORANGE);
        panel3.setBorder(new TitledBorder("Third Panel Here"));

        // add the buttons to 1st panel
        panel1.add(addButtonsToPanel(buttonNames), BorderLayout.LINE_START);
        // add the combos to the top of 2nd panel 
        panel2.add(addCombosToPanel(comboFirstNames), BorderLayout.PAGE_START);
        // give the 3rd panel some size
        panel3.add(new JLabel(new ImageIcon(new BufferedImage(400,200,BufferedImage.TYPE_INT_ARGB))));

        // now assemble them all together
        panel2.add(panel3, BorderLayout.CENTER);
        panel1.add(panel2, BorderLayout.CENTER);
        ui.add(panel1, BorderLayout.CENTER);
    }

    private JPanel addButtonsToPanel(String[] ids) {
        JPanel p = new JPanel(new GridLayout(0, 2));
        for (String id : ids) {
            p.add(new JButton(id));
        }
        return p;
    }

    private JPanel addCombosToPanel(String[][] ids) {
        JPanel p = new JPanel(new FlowLayout());
        for (String[] id : ids) {
            p.add(new JComboBox<String>(id));
        }
        return p;
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
                ThreePanelLayout o = new ThreePanelLayout();

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