import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

public class GridBagEg {
    private static void createAndShowGui() {
        PlayerEditorPanel playerEditorPane = new PlayerEditorPanel();

        int result = JOptionPane.showConfirmDialog(null, playerEditorPane, "Edit Player",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            // TODO: do something with info

            for (PlayerEditorPanel.FieldTitle fieldTitle : PlayerEditorPanel.FieldTitle.values()) {
                System.out.printf("%10s: %s%n", fieldTitle.getTitle(),
                        playerEditorPane.getFieldText(fieldTitle));
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}

@SuppressWarnings("serial")
class PlayerEditorPanel extends JPanel {
    enum FieldTitle {
        NAME("Name", KeyEvent.VK_N), SPEED("Speed", KeyEvent.VK_P), STRENGTH("Strength", KeyEvent.VK_T);
        private String title;
        private int mnemonic;

        private FieldTitle(String title, int mnemonic) {
            this.title = title;
            this.mnemonic = mnemonic;
        }

        public String getTitle() {
            return title;
        }

        public int getMnemonic() {
            return mnemonic;
        }
    };

    private static final Insets WEST_INSETS = new Insets(5, 0, 5, 5);
    private static final Insets EAST_INSETS = new Insets(5, 5, 5, 0);
    private Map<FieldTitle, JTextField> fieldMap = new HashMap<FieldTitle, JTextField>();

    public PlayerEditorPanel() {
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Player Editor"),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        GridBagConstraints gbc;
        for (int i = 0; i < FieldTitle.values().length; i++) {
            FieldTitle fieldTitle = FieldTitle.values()[i];
            JLabel label = new JLabel(fieldTitle.getTitle() + ":", JLabel.LEFT);
            JTextField textField = new JTextField(10);
            label.setDisplayedMnemonic(fieldTitle.getMnemonic());
            label.setLabelFor(textField);
            gbc = createGbc(0, i);
            add(label, gbc);
            gbc = createGbc(1, i);
            add(textField, gbc);

            fieldMap.put(fieldTitle, textField);
        }
    }

    private GridBagConstraints createGbc(int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;

        gbc.anchor = (x == 0) ? GridBagConstraints.WEST : GridBagConstraints.EAST;
        gbc.fill = (x == 0) ? GridBagConstraints.BOTH : GridBagConstraints.HORIZONTAL;

        gbc.insets = (x == 0) ? WEST_INSETS : EAST_INSETS;
        gbc.weightx = (x == 0) ? 0.1 : 1.0;
        gbc.weighty = 1.0;
        return gbc;
    }

    public String getFieldText(FieldTitle fieldTitle) {
        return fieldMap.get(fieldTitle).getText();
    }

}