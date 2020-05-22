import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class Test {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new JLabel("Boo"));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                DefaultTableModel model = new DefaultTableModel(new String[]{"One"}, 1);
                model.addTableModelListener(new TableModelListener() {
                    @Override
                    public void tableChanged(TableModelEvent e) {
                        System.out.println("isEventDispatchingThread - " + EventQueue.isDispatchThread());
                    }
                });

                Thread t = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        model.setValueAt("Test", 0, 0);
                    }
                });
                t.start();

            }
        });
    }

}