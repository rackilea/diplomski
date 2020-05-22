import java.awt.Component;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

public class CarCareChoice {

    private JFrame frame;
    private String[] services = {"Oil change", "Tire rotation", "Battery check", "Brake inspection"};

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CarCareChoice carCareChoice = new CarCareChoice();
//              carCareChoice.comboWay();
//              carCareChoice.radioWay();
                carCareChoice.textUglyWay();
            }
        });
    }

    public void comboWay() {
        frame = new JFrame();

        String userSelection = (String) JOptionPane.showInputDialog(frame, "Please select one of the following", "Service selection", 
                JOptionPane.PLAIN_MESSAGE, null, services, services[0]);

        if (userSelection != null) {
            JOptionPane.showMessageDialog(frame, "The service selected was: " + userSelection);
        }
    }

    public void radioWay() {
        frame = new JFrame();
        JPanel pane = new JPanel();
        JRadioButton[] buttons = new JRadioButton[services.length];
        ButtonGroup group = new ButtonGroup();

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JRadioButton(services[i]);
            group.add(buttons[i]);
            pane.add(buttons[i]);
        }

        int option = JOptionPane.showConfirmDialog(frame, pane, "Service selection", JOptionPane.PLAIN_MESSAGE, JOptionPane.YES_NO_OPTION);

        JRadioButton userSelection = null;

        if (option == JOptionPane.YES_OPTION) {
            for (Component c : pane.getComponents()) {
                if (c instanceof JRadioButton) {
                    if (((JRadioButton) c).isSelected()) {
                        userSelection = (JRadioButton) c;
                        break;
                    }
                }
            }
            if (userSelection != null) {
                JOptionPane.showMessageDialog(frame, "Service selected: " + userSelection.getText());
            } else {
                JOptionPane.showMessageDialog(frame, "C'mon man! Select something");
            }
        }
    }

    public void textUglyWay() {
        frame = new JFrame();

        String userSelection = (String) JOptionPane.showInputDialog(frame, "Please select one of the following", "Service selection", 
                JOptionPane.PLAIN_MESSAGE);

        if (userSelection != null && !userSelection.equals("")) {
            for (String s : services) {
                if (s.toLowerCase().startsWith(userSelection.toLowerCase())) {
                    userSelection = s;
                    break;
                }
            }
            JOptionPane.showMessageDialog(frame, "The service selected was: " + userSelection);
        }
    }
}