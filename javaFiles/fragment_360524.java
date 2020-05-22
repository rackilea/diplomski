import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class VirtualKeyBoard {
    private JFrame frame;
    private JPanel mainPane;
    private GridBagConstraints c;
    private JLabel label;

    private static final String[] NUMBERS = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
    private static final String[] FIRST_ROW_LETTERS = new String[] {"Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P"};
    private static final String[] SECOND_ROW_LETTERS = new String[] {"A", "S", "D", "F", "G", "H", "J", "K", "L"};
    private static final String[] THIRD_ROW_LETTERS = new String[] {"Z", "X", "C", "V", "B", "N", "M"};

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new VirtualKeyBoard()::createAndShowGui);
    }

    private void createAndShowGui() {
        frame = new JFrame();
        mainPane = new JPanel();
        mainPane.setLayout(new GridLayout(6, 1, 5, 5));

        label = new JLabel("");
        label.setHorizontalAlignment(SwingConstants.CENTER);

        c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.fill = GridBagConstraints.BOTH;

        mainPane.add(addRow(NUMBERS));
        mainPane.add(addRow(FIRST_ROW_LETTERS));
        mainPane.add(addRow(SECOND_ROW_LETTERS));
        mainPane.add(addRow(THIRD_ROW_LETTERS));

        JButton spaceButton = new JButton("SPACE");
        spaceButton.addActionListener(listener);

        mainPane.add(spaceButton);
        mainPane.add(label);

        frame.add(mainPane);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private ActionListener listener = e -> {
        if (e.getActionCommand().equals("SPACE")) {
            label.setText("");
        } else {
            label.setText(e.getActionCommand());
        }
    };

    private JPanel addRow(String[] values) {
        JPanel pane = new JPanel();
        pane.setLayout(new GridBagLayout());

        for (String s : values) {
            c.gridx++;
            JButton button = new JButton(s);
            button.addActionListener(listener);
            pane.add(button, c);
        }

        return pane;
    }
}