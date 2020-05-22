import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class RadioFun extends JPanel {
    private static final int PREF_W = 300;
    private static final int PREF_H = 150;
    private JRadioButton rbOgret = new JRadioButton("Ogret");
    private JTextField txtMaas = new JTextField(10);

    public RadioFun() {
        setLayout(new FlowLayout(FlowLayout.LEADING));
        add(rbOgret);
        add(txtMaas);

        txtMaas.setVisible(false);

        rbOgret.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                rbOgretItemStateChanged(e);
            }
        });
    }    

    // to make the GUI large enough
    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    private void rbOgretItemStateChanged(ItemEvent e) {
        boolean visible = e.getStateChange() == ItemEvent.SELECTED;
        txtMaas.setVisible(visible);

        // call repaint and revalidate on the holding JPanel:
        revalidate();
        repaint();
    }

    // the two methods below are to create the GUI on the Swing event thread
    private static void createAndShowGui() {
        JFrame frame = new JFrame("RadioFun");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new RadioFun());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}