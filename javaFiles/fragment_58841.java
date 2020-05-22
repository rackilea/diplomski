import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.*;

/**
* @see http://en.wikipedia.org/wiki/Observer_pattern
* @see https://stackoverflow.com/a/10523401/230513
*/
public class PropertyChangeDemo {

    public PropertyChangeDemo() {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.add(new ObserverPanel());
        f.pack();
        f.setLocationByPlatform(true);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                PropertyChangeDemo example = new PropertyChangeDemo();
            }
        });
    }
}

class ObserverPanel extends JPanel {

    private JLabel title = new JLabel("Value received: ");
    private JLabel label = new JLabel("null", JLabel.CENTER);

    public ObserverPanel() {
        this.setBorder(BorderFactory.createTitledBorder("ObserverPanel"));
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(title);
        panel.add(label);
        this.add(panel);
        ObservedPanel observed = new ObservedPanel();
        observed.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent e) {
                if (e.getPropertyName().equals(ObservedPanel.PHYSICIST)) {
                    String value = e.getNewValue().toString();
                    label.setText(value);
                }
            }
        });
        this.add(observed);
    }
}

class ObservedPanel extends JPanel {

    public static final String PHYSICIST = "Physicist";
    private static final String[] items = new String[]{
        "Alpher", "Bethe", "Gamow", "Dirac", "Einstein"
    };
    private JComboBox combo = new JComboBox(items);
    private String oldValue;

    public ObservedPanel() {
        this.setBorder(BorderFactory.createTitledBorder("ObservedPanel"));
        combo.addActionListener(new ComboBoxListener());
        this.add(combo);
    }

    private class ComboBoxListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String newValue = (String) combo.getSelectedItem();
            firePropertyChange(PHYSICIST, oldValue, newValue);
            oldValue = newValue;
        }
    }
}