import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import static javax.swing.Action.NAME;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                DefaultListModel model = new DefaultListModel();
                model.addElement("One");
                model.addElement("Two");
                model.addElement("Three");
                model.addElement("Four");
                JList list = new JList(model);
                JPopupMenu popupMenu = new JPopupMenu();
                popupMenu.add(new ShowItemAction(list));
                list.setComponentPopupMenu(popupMenu);

                list.addMouseListener(new MouseAdapter() {

                    @Override
                    public void mousePressed(MouseEvent e) {
                        if (SwingUtilities.isRightMouseButton(e)) {
                            int row = list.locationToIndex(e.getPoint());
                            list.setSelectedIndex(row);
                        }
                    }

                });

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new JScrollPane(list));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class ShowItemAction extends AbstractAction {

        private JList list;

        public ShowItemAction(JList list) {
            this.list = new JList();
            putValue(NAME, "Showing ...");

            list.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting()) {
                        int index = list.getSelectedIndex();
                        String value = list.getSelectedValue().toString();
                        putValue(NAME, "Showing " + value + " @ " + index);
                    }
                }
            });
        }

        @Override
        public void actionPerformed(ActionEvent e) {
        }

    }

}