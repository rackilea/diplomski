import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ModalOverModal {

    private JComponent ui = null;

    ModalOverModal() {
        initUI();
    }

    public void initUI() {
        if (ui!=null) return;

        ui = new JPanel(new GridLayout());
        ui.setBorder(new EmptyBorder(40,40,40,40));

        final JButton b1 = new JButton("Open Modal Dialog");
        b1.setMargin(new Insets(40, 200, 40, 200));
        ui.add(b1);

        final JButton b2 = new JButton("Open 2nd Modal Dialog");

        ActionListener al1 = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(b1, b2);
            }
        };
        b1.addActionListener(al1);

        ActionListener al2 = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(b2, "Close Me!");
            }
        };
        b2.addActionListener(al2);
    }

    public JComponent getUI() {
        return ui;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                ModalOverModal o = new ModalOverModal();

                JFrame f = new JFrame("Modal over Modal");
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