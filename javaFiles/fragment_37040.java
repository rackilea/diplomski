import java.awt.FlowLayout;
import javax.swing.*;

class TimeBeforeClass {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JPanel gui = new JPanel(new FlowLayout(FlowLayout.LEFT, 3,3));
                gui.add(new JLabel("Open"));
                gui.add(new JSpinner(new SpinnerNumberModel(15,0,20,1)));
                gui.add(new JLabel("minutes before class"));
                JOptionPane.showMessageDialog(null, gui);
            }
        });
    }
}