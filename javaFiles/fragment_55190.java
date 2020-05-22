import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;
import javax.swing.event.SwingPropertyChangeSupport;

@SuppressWarnings("serial")
public class ShowCount extends JPanel {
    private static final int TIMER_DELAY = 1000;
    private JLabel countLabel = new JLabel("                 ");
    private CountModel model = new CountModel();

    public ShowCount() {
        model.addPropertyChangeListener(CountModel.COUNT, new ModelListener(this));

        setPreferredSize(new Dimension(250, 50));
        add(new JLabel("Count:"));
        add(countLabel);

        Timer timer = new Timer(TIMER_DELAY, new TimerListener(model));
        timer.start();
    }

    public void setCountLabelText(String text) {
        countLabel.setText(text);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }

    private static void createAndShowGui() {
        ShowCount mainPanel = new ShowCount();
        JFrame frame = new JFrame("ShowCount");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
}