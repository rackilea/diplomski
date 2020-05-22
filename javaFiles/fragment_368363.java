import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListOptionTest {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                String[] data = new String[10];
                for (int i = 0; i < 10; i++) {
                    data[i] = "Item " + (i + 1);
                }
                final JList<String> list = new JList<>(data);
                list.addListSelectionListener(new ListSelectionListener() {

                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        if (!e.getValueIsAdjusting()) {
                            System.out.println("Current selection: " + list.getSelectedValuesList());
                        }
                    }
                });
                int result = JOptionPane.showConfirmDialog(null, new JScrollPane(list), "Make your choice",
                        JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    System.out.println("Final selection: " + list.getSelectedValuesList());
                } else {
                    System.out.println("No choice");
                }
            }
        });
    }
}