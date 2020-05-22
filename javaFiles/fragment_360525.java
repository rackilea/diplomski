import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class SimpleVirtualKeyBoard {
    private JFrame frame;
    private JPanel pane;
    private JButton[] buttons;
    private JButton spaceButton;
    private JLabel label;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new SimpleVirtualKeyBoard()::createAndShowGui);
    }

    private void createAndShowGui() {
        frame = new JFrame(getClass().getSimpleName());

        pane = new JPanel();
        pane.setLayout(new GridLayout(0, 6, 10, 10));

        String[] letters = new String[26];

        spaceButton = new JButton("SPACE");
        spaceButton.addActionListener(listener);

        label = new JLabel(" ");
        label.setHorizontalAlignment(SwingConstants.CENTER);

        for (char i = 'A'; i <= 'Z'; i++) {
            letters[i - 'A'] = String.valueOf(i); //We fill our alphabet array
            System.out.println(letters[i - 'A']);
        }

        buttons = new JButton[26];

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(letters[i]);
            buttons[i].addActionListener(listener);

            pane.add(buttons[i]);
        }

        pane.add(spaceButton);

        frame.add(pane);
        frame.add(label, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private ActionListener listener = e -> {
        label.setText(e.getActionCommand());
    };
}