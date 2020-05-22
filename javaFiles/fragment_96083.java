import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class Demo {

    private void createAndShowGUI() {

        DefaultTableModel model = new DefaultTableModel(new Object[]{"TimeStamp", "Value"}, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                switch(columnIndex) {
                    case 0: return Date.class;
                    default:  return super.getColumnClass(columnIndex);
                }
            }
        };

        final JTable table = new JTable(model);

        JButton button = new JButton("Add entry...");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InputDialog((DefaultTableModel)table.getModel()).createAndShowGUI();
            }
        });

        JFrame frame = new JFrame("Demo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    class InputDialog {

        private final DefaultTableModel model;

        public InputDialog(DefaultTableModel model) {
            this.model = model;
        }

        public void createAndShowGUI() {

            final JTextField textField = new JTextField(10);
            textField.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    model.addRow(new Object[]{new Date(), textField.getText()});
                    Window window = SwingUtilities.windowForComponent((Component)e.getSource());
                    window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
                }
            });

            JPanel panel = new JPanel();
            panel.add(new JLabel("Please input a value and press ENTER key:"));
            panel.add(textField);

            JDialog dialog = new JDialog();
            dialog.setModal(true);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.add(panel);
            dialog.pack();
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
        }

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