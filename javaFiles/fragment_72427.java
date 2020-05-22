import java.awt.*;
import javax.swing.*;

class LabelButtonLayout {

    public static Component getButtonLayout(int num) {
        JPanel p = new JPanel(new BorderLayout(3,3));

        p.add(new JLabel("Label " + num), BorderLayout.NORTH);

        JPanel b = new JPanel(new GridLayout(1,0,25,5));
        for (int ii=1; ii<4; ii++) {
            b.add(new JButton("Button " + ii));
        }
        p.add(b, BorderLayout.CENTER);

        return p;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater( new Runnable() {
            public void run() {
                JPanel gui = new JPanel(new GridLayout(0,1,3,15));
                for (int ii=1; ii<4; ii++) {
                    gui.add(getButtonLayout(ii));
                }
                JOptionPane.showMessageDialog(null, gui);
            }
        });
    }
}