import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class List {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new List();
    }

    public List() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                final JFrame selected = new JFrame("Selected");
                selected.add(new JLabel("Here I am"));
                selected.pack();

                DefaultListModel model = new DefaultListModel();
                for (int index = 0; index < 1000; index++) {
                    model.addElement("#" + index);
                }
                final JList list = new JList(model);
                list.addListSelectionListener(new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        int index = list.getSelectedIndex();
                        Rectangle bounds = list.getCellBounds(index, index);
                        Point p = bounds.getLocation();
                        p.y += bounds.height;
                        SwingUtilities.convertPointToScreen(p, list);
                        p.x -= selected.getWidth();
                        selected.setLocation(p);
                        selected.setVisible(true);
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

}