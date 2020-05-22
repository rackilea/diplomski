import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * @see http://stackoverflow.com/a/17904479/230513
 */
public class Test {

    private static class MyPanel extends JPanel {

        String[] num = {"1 One", "2 Two", "3 Three"};

        public MyPanel() {
            this.setLayout(new GridLayout());
            JList list = new JList(new MyModel(num));
            list.setVisibleRowCount(3);
            JScrollPane pane = new JScrollPane(list);
            this.add(pane);
        }
    }

    private static class MyModel extends DefaultListModel {

        public MyModel(String[] numbers) {
            for (String string : numbers) {
                this.addElement(string);
            }
        }
    }

    private void display() {
        JFrame f = new JFrame("Test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new MyPanel());
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Test().display();
            }
        });
    }
}