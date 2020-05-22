import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class TwoWindows {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }

    private static void createAndShowGui() {
        MainGui mainPanel = new MainGui();
        mainPanel.setPreferredSize(new Dimension(400, 250));
        JFrame frame = new JFrame("Main GUI");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

class MainGui extends JPanel {
    private SubWindow subWindow = new SubWindow();
    private JDialog dialog;
    private JTextField textField = new JTextField("Text in field", 10);

    public MainGui() {
        add(textField);
        add(new JButton(new ShowDetailAction("Show Detail")));
    }

    private class ShowDetailAction extends AbstractAction {
        public ShowDetailAction(String name) {
            super(name);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // if dialog not yet created -- create it
            if (dialog == null) {
                Window win = SwingUtilities.getWindowAncestor(MainGui.this);
                dialog = new JDialog(win, "Details Window", ModalityType.MODELESS);
                dialog.add(subWindow);
                dialog.pack();
                dialog.setLocationRelativeTo(win);
            }
            String text = textField.getText();
            subWindow.passText(text);
            dialog.setVisible(true);
        }
    }
}

class SubWindow extends JPanel {
    private JLabel textLabel = new JLabel(" ");

    public SubWindow() {
        setPreferredSize(new Dimension(300, 60));
        add(new JLabel("Details:"));
        add(textLabel);
    }

    public void passText(String text) {
        textLabel.setText(text);
    }

}