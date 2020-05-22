import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings("serial")
public class ListListenerDemo extends JPanel {
    private static final String[] LIST_DATA = { "Sunday", "Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday" };
    private JList<String> list = new JList<>(LIST_DATA);

    public ListListenerDemo() {
        list.setVisibleRowCount(4);

        // add the ListSelectionListener to our JList
        list.addListSelectionListener(new MyListListener()); 

        JScrollPane scrollPane = new JScrollPane(list);
        add(scrollPane);
    }

    // here's our ListSelectionListener
    private class MyListListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                JList<String> lst = (JList<String>) e.getSource();
                String selection = lst.getSelectedValue();
                if (selection != null) {
                    JOptionPane.showMessageDialog(list, selection, "Selected Item",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }

    private static void createAndShowGui() {
        ListListenerDemo mainPanel = new ListListenerDemo();

        JFrame frame = new JFrame("ListListenerDemo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}