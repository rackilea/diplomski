import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.*;

public class KeyBoardLayout {

    private JComponent ui = null;

    KeyBoardLayout(boolean lowImpact) {
        initUI(lowImpact);
    }

    public void initUI(boolean lowImpact) {
        if (ui != null) {
            return;
        }

        ui = new JPanel(new GridBagLayout());
        ui.setBorder(new EmptyBorder(4, 4, 4, 4));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = .5;
        gbc.weighty = .5;
        gbc.fill = GridBagConstraints.BOTH;

        /* This code adds a dummy (invisible) row of components, 1 per 
         single gridwidth column.  It has the effect of forcing the GBL width 
         to the size we would expect, proportional to each gridwidth assigned.
         The problem with this (simple) approach is that the perfect 
         width will change according to PLAF and the content/preferred 
         size of the visible components. */
        // TODO! improve on use of 'magic numbers'
        int w = 30; // adjust width per requirement
        int h = lowImpact ? 1 : 5; // 1 for small height/border, 5 for large
        // TYPE_INT_RGB for black
        // TYPE_INT_ARGB for invisible
        int t = lowImpact ? 
                BufferedImage.TYPE_INT_ARGB : 
                BufferedImage.TYPE_INT_RGB;
        // an icon for the dummy row
        ImageIcon ii = new ImageIcon(new BufferedImage(w, h, t));
        ui.setBorder(new CompoundBorder(
                ui.getBorder(), new EmptyBorder(0, 0, h, 0)));
        // put a 'padding cell' in each column of the top row
        // to force the layout to respect each individual column
        for (int i = 0; i < 22; i++) {
            gbc.gridx = i;
            gbc.gridy = 4;
            ui.add(new JLabel(ii));
        }

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        ui.add(new JButton("1,1 (3)"), gbc);

        gbc.gridx = 3;
        gbc.gridwidth = 2;
        ui.add(new JButton("2,1 (2)"), gbc);

        gbc.gridx = 5;
        ui.add(new JButton("3,1 (2)"), gbc);

        gbc.gridx = 7;
        ui.add(new JButton("4,1 (2)"), gbc);

        gbc.gridx = 9;
        ui.add(new JButton("5,1 (2)"), gbc);

        gbc.gridx = 11;
        ui.add(new JButton("6,1 (2)"), gbc);

        gbc.gridx = 13;
        ui.add(new JButton("7,1 (2)"), gbc);

        gbc.gridx = 15;
        gbc.gridwidth = 3;
        ui.add(new JButton("8,1 (3)"), gbc);

        gbc.gridx = 18;
        gbc.gridwidth = 4;
        ui.add(new JButton("9,1 (4)"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        ui.add(new JButton("1,2 (4)"), gbc);

        gbc.gridx = 4;
        gbc.gridwidth = 2;
        ui.add(new JButton("2,2 (2)"), gbc);

        gbc.gridx = 6;
        ui.add(new JButton("3,2 (2)"), gbc);

        gbc.gridx = 8;
        ui.add(new JButton("4,2 (2)"), gbc);

        gbc.gridx = 10;
        ui.add(new JButton("5,2 (2)"), gbc);

        gbc.gridx = 12;
        ui.add(new JButton("6,2 (2)"), gbc);

        gbc.gridx = 14;
        ui.add(new JButton("7,2 (2)"), gbc);

        gbc.gridx = 16;
        ui.add(new JButton("8,2 (2)"), gbc);

        gbc.gridx = 18;
        gbc.gridwidth = 4;
        ui.add(new JButton("9,2 (4)"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 5;
        ui.add(new JButton("1,3 (5)"), gbc);

        gbc.gridx = 5;
        gbc.gridwidth = 2;
        ui.add(new JButton("2,3 (2)"), gbc);

        gbc.gridx = 7;
        ui.add(new JButton("3,3 (2)"), gbc);

        gbc.gridx = 9;
        ui.add(new JButton("4,3 (2)"), gbc);

        gbc.gridx = 11;
        ui.add(new JButton("5,3 (2)"), gbc);

        gbc.gridx = 13;
        ui.add(new JButton("6,3 (2)"), gbc);

        gbc.gridx = 15;
        ui.add(new JButton("7,3 (2)"), gbc);

        gbc.gridx = 17;
        ui.add(new JButton("8,3 (2)"), gbc);

        gbc.gridx = 19;
        gbc.gridwidth = 3;
        ui.add(new JButton("9,3 (3)"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        ui.add(new JButton("1,4 (3)"), gbc);

        gbc.gridx = 3;
        ui.add(new JButton("2,4 (3)"), gbc);

        gbc.gridx = 6;
        gbc.gridwidth = 10;
        ui.add(new JButton("3,4 (10)"), gbc);

        gbc.gridx = 16;
        gbc.gridwidth = 3;
        ui.add(new JButton("4,4 (3)"), gbc);

        gbc.gridx = 19;
        ui.add(new JButton("5,4 (3)"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
    }

    public JComponent getUI() {
        return ui;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(
                            UIManager.getSystemLookAndFeelClassName());
                } catch (Exception useDefault) {
                }
                for (int ii = 0; ii < 2; ii++) {
                    KeyBoardLayout o = new KeyBoardLayout(ii==0);

                    JFrame f = new JFrame("Keyboard Layout");
                    f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    f.setLocationByPlatform(true);

                    f.setContentPane(o.getUI());
                    f.pack();
                    f.setMinimumSize(f.getSize());

                    f.setVisible(true);
                }
            }
        };
        SwingUtilities.invokeLater(r);
    }
}