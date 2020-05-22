import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class CenteredButtons2 {

    private JComponent ui = null;

    CenteredButtons2() {
        initUI();
    }

    public void initUI() {
        if (ui!=null) return;

        ui = new JPanel(new GridBagLayout()); // to center a single component
        ui.setBorder(new EmptyBorder(4,4,4,4));

        JPanel controls = new JPanel(new FlowLayout());
        for (int ii=1; ii<4; ii++) {
            controls.add(new JButton("Button " + ii));
        }
        controls.setBorder(new EmptyBorder(50, 90, 50, 90));
        ui.add(controls);
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
                CenteredButtons2 o = new CenteredButtons2();

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