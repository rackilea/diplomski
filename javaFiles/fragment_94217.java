import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JComboBox.KeySelectionManager;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
                for (int index = 0; index < 50; index++) {
                    model.addElement(Integer.toString(index));
                }

                JComboBox cb = new JComboBox(model);
                cb.setKeySelectionManager(new MyKeySelectionManager());
                JFrame frame = new JFrame();
                JPanel content = new JPanel(new GridBagLayout());
                content.setBorder(new EmptyBorder(32, 32, 32, 32));
                content.add(cb);
                frame.setContentPane(content);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class MyKeySelectionManager implements KeySelectionManager {

        private Timer timeout;
        private StringBuilder pattern = new StringBuilder(32);

        public MyKeySelectionManager() {
            timeout = new Timer(250, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    pattern.delete(0, pattern.length());
                }
            });
            timeout.setRepeats(false);
        }

        protected int indexOf(Object item, ComboBoxModel<?> model) {
            for (int index = 0; index < model.getSize(); index++) {
                if (model.getElementAt(index) == item) {
                    return index;
                }
            }
            return -1;
        }

        @Override
        public int selectionForKey(char aKey, ComboBoxModel<?> model) {
            timeout.stop();
            pattern.append(Character.toLowerCase(aKey));
            String match = pattern.toString();
            for (int index = 0; index < model.getSize(); index++) {
                String text = model.getElementAt(index).toString().toLowerCase();
                if (text.startsWith(match)) {
                    timeout.start();
                    return index;
                }
            }

            timeout.start();
            return -1;
        }

    }

}