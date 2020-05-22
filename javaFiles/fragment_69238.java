import java.awt.BorderLayout;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

@SuppressWarnings("serial")
public class PowerDialogPanel extends JPanel {
    private static final int I_GAP = 4;
    public static final String[][] LABEL_TEXTS = {
        {"Name", "Level", "Timing"},
        {"Skill", "Defense", "Target"},
        {"RNG", "Encroach", "Restriction"}
    };
    private static final int TF_COLS = 10;
    private static final String TITLE_TEXT = "Power Information";
    private Map<String, JTextField> labelFieldMap = new HashMap<>();

    public PowerDialogPanel() {
        JPanel centerPanel = new JPanel(new GridBagLayout());
        for (int row = 0; row < LABEL_TEXTS.length; row++) {
            for (int col = 0; col < LABEL_TEXTS[row].length; col++) {
                String text = LABEL_TEXTS[row][col];
                JLabel label = new JLabel(text + ":");
                JTextField textField = new JTextField(TF_COLS);
                labelFieldMap.put(text, textField);

                int x = 2 * col;
                centerPanel.add(label, createGbc(x, row));
                centerPanel.add(textField, createGbc(x + 1, row));
            }
        }

        JButton submitButton = new JButton(new AbstractAction("Submit") {

            @Override
            public void actionPerformed(ActionEvent e) {
                Window win = SwingUtilities.getWindowAncestor(PowerDialogPanel.this);
                win.dispose();
            }
        });

        setLayout(new BorderLayout(I_GAP, I_GAP));
        add(new JLabel(TITLE_TEXT), BorderLayout.PAGE_START);
        add(centerPanel, BorderLayout.CENTER);
        add(submitButton, BorderLayout.PAGE_END);
    }

    public String getText(String labelText) {
        return labelFieldMap.get(labelText).getText();
    }

    private GridBagConstraints createGbc(int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.weighty = 0.0;
        gbc.insets = new Insets(I_GAP, I_GAP, I_GAP, I_GAP);
        gbc.anchor = x % 2 == 0 ? GridBagConstraints.WEST : GridBagConstraints.EAST;
        return gbc;
    }

    private static void createAndShowGui() {
        final PowerDialogPanel powerDialogPanel = new PowerDialogPanel();

        final JFrame frame = new JFrame("Power Frame");
        final JDialog dialog = new JDialog(frame, "Power Dialog", ModalityType.APPLICATION_MODAL);
        dialog.add(powerDialogPanel);
        dialog.pack();
        dialog.setLocationRelativeTo(null);

        JPanel framePanel = new JPanel();
        framePanel.add(new JButton(new AbstractAction("Show Power Dialog") {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                dialog.setVisible(true);
                for (String[] strings : LABEL_TEXTS) {
                    for (String labelText : strings) {
                        System.out.printf("%12s: %s%n", labelText, powerDialogPanel.getText(labelText));
                    }
                }
            }
        }));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(framePanel);
        frame.pack();
        frame.setLocationByPlatform(true);
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