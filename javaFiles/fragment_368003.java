import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Controller implements Observer {
    private static final Insets INSETS = new Insets(1, 1, 1, 1);
    private Chronometer chrono = new Chronometer();
    private final JLabel message = new JLabel();

    public Controller() {
        final JFrame messageFrame = new JFrame("Warning");

        messageFrame.setLayout(new GridBagLayout());
        messageFrame.setSize(1000,1000);
        messageFrame.setLocationRelativeTo(null);

        addComponent(messageFrame, message, 0, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.CENTER);

        messageFrame.setVisible(true);

        chrono.addObserver(this);
    }

    public void startChrono(int delay) {
        chrono.startCountDown(delay);
    }

    public void refreshLabel() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                message.setText("Preventing connection block. Next query in " + chrono.getTime()/1000 + " seconds.");
            }
        });
    }

    @Override
    public void update(Observable o, Object arg) {
        refreshLabel();
    }

    private static void addComponent(Container container, Component component, int gridx, int gridy, int gridwidth, int gridheight, int anchor, int fill) {
        GridBagConstraints gbc = new GridBagConstraints(gridx, gridy, gridwidth, gridheight, 1.0, 1.0,anchor, fill, INSETS, 0, 0);
        container.add(component, gbc);
    }
}