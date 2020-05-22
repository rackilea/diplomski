import java.awt.BorderLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TestDialog {

    protected static void initUI() {
        JPanel pane = newPane("Label in frame");
        JFrame frame = new JFrame("Title");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(pane);
        frame.pack();
        frame.setVisible(true);

    }

    public static JPanel newPane(String labelText) {
        JPanel pane = new JPanel(new BorderLayout());
        pane.add(newLabel(labelText));
        pane.add(newButton("Open dialog"), BorderLayout.SOUTH);
        return pane;
    }

    private static JButton newButton(String label) {
        final JButton button = new JButton(label);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Window parentWindow = SwingUtilities.windowForComponent(button);
                JDialog dialog = new JDialog(parentWindow);
                dialog.setLocationRelativeTo(button);
                dialog.setModal(true);
                dialog.add(newPane("Label in dialog"));
                dialog.pack();
                dialog.setVisible(true);
            }
        });
        return button;
    }

    private static JLabel newLabel(String label) {
        JLabel l = new JLabel(label);
        l.setFont(l.getFont().deriveFont(24.0f));
        return l;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                initUI();
            }
        });
    }
}