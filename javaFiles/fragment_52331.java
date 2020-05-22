import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

class TestSizeOfGui {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JTextField account = new JTextField(10);
                JPanel accountPanel = new JPanel(new GridLayout());
                accountPanel.add(account);
                accountPanel.setBorder(new TitledBorder("Account"));

                String[] firstDigitList = {
                    "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

                JLabel firstDigitListLabel = new JLabel("Leading Digit Change");
                JPanel firstDigitListPanel = new JPanel(new BorderLayout(4,2));
                firstDigitListPanel.add(firstDigitListLabel, BorderLayout.WEST);
                JComboBox firstDigitCombo = new JComboBox(firstDigitList);
                firstDigitListPanel.add(firstDigitCombo);
                firstDigitCombo.setSelectedIndex(0);
                firstDigitListPanel.setBorder(new TitledBorder("LDC"));

                JPanel panel = new JPanel();
                panel.add(accountPanel);
                panel.add(firstDigitListPanel);

                int result = JOptionPane.showConfirmDialog(
                    null,
                    panel,
                    "Please Enter Values",
                    JOptionPane.OK_CANCEL_OPTION);

                }
            });
    }
}