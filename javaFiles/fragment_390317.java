import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ListDemo extends JPanel {

    private static final long serialVersionUID = 1L;
    private JFrame frame = new JFrame("ListDemo");
    private JList list;
    private DefaultListModel listModel;

    public ListDemo() {
        super(new BorderLayout());
        listModel = new DefaultListModel();
        listModel.addElement("Jane Doe");
        listModel.addElement("John Smith");
        listModel.addElement("Kathy Green");
        list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.setVisibleRowCount(5);
        JScrollPane listScrollPane = new JScrollPane(list);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(listScrollPane, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
        setKeyBindings();
    }

    private void setKeyBindings() {
        list.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT)
                .put(KeyStroke.getKeyStroke("DELETE"), "clickDelete");
        list.getActionMap().put("clickDelete", new AbstractAction() {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                int index = list.getSelectedIndex();
                if (index > -1) {
                    listModel.remove(index);
                }
            }
        });
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                ListDemo listDemo = new ListDemo();
            }
        });
    }
}