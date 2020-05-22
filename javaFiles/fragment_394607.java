import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

class CenterComponent {

    public static JLabel getLabel(String text) {
        return getLabel(text, SwingConstants.LEFT);
    }

    public static JLabel getLabel(String text, int alignment) {
        JLabel l = new JLabel(text, alignment);
        l.setBorder(new LineBorder(Color.RED, 2));
        return l;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JPanel p = new JPanel(new GridLayout(2,2,4,4));
                p.setBackground(Color.black);
                p.setBorder(new EmptyBorder(4,4,4,4));

                JPanel border = new JPanel(new BorderLayout());
                border.add(getLabel(
                    "Border", SwingConstants.CENTER), BorderLayout.CENTER);
                p.add(border);

                JPanel gridbag = new JPanel(new GridBagLayout());
                gridbag.add(getLabel("GridBag"));
                p.add(gridbag);

                JPanel grid = new JPanel(new GridLayout());
                grid.add(getLabel("Grid", SwingConstants.CENTER));
                p.add(grid);

                // from @0verbose
                JPanel box = new JPanel();
                box.setLayout(new BoxLayout(box, BoxLayout.X_AXIS ));

                box.add(Box.createHorizontalGlue());
                box.add(getLabel("Box"));
                box.add(Box.createHorizontalGlue());
                p.add(box);

                JFrame f = new JFrame("Streeeetch me..");
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setContentPane(p);
                f.pack();
                f.setLocationByPlatform(true);
                f.setVisible(true);
            }
        });
    }
}