import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class Demo {

    private JList list;
    private JTextField textField;

    private void createAndShowGUI() {

        KeyStroke enterKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);

        Action nextStepAction = new AbstractAction("Next") {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Going to step 3!", "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        };

        Action updateTextfieldAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText((String)list.getSelectedValue());
            }
        };

        list = new JList(new String[]{"Item 1", "Item 2", "Item 3"});
        list.setPrototypeCellValue("This is a list's prototype cell value.");
        list.getInputMap().put(enterKeyStroke, "enter");
        list.getActionMap().put("enter", updateTextfieldAction);

        textField = new JTextField(15);

        JPanel listPanel = new JPanel();
        listPanel.add(new JScrollPane(list));
        listPanel.add(textField);

        JButton button = new JButton(nextStepAction);
        button.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(enterKeyStroke, "enter");
        button.getActionMap().put("enter", nextStepAction);

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        buttonsPanel.add(button);

        JFrame frame = new JFrame("Demo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(listPanel);
        frame.add(buttonsPanel, BorderLayout.PAGE_END);
        frame.getRootPane().setDefaultButton(button);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Demo().createAndShowGUI();
            }
        });
    }
}