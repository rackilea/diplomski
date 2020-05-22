import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                TextListener tl1 = new TextListener();
                TextSource ts1 = new TextSource();
                frame.setLayout(new FlowLayout());
                frame.add(tl1);
                frame.add(ts1);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TextListener extends JPanel {

        public TextListener() {
            JTextArea stuff = new JTextArea(45, 70);
            JScrollPane scroll = new JScrollPane(stuff);

            stuff.setEditable(false);
            scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

            setLayout(new FlowLayout());
            add(stuff);
            setBackground(Color.YELLOW);
        }
    }

    public class TextSource extends JPanel {

        public TextSource() {
            JTextField tf1 = new JTextField(8);
            JLabel lb1 = new JLabel("Text Source");

            setLayout(new FlowLayout());

            add(tf1);
            add(lb1);

            setBackground(Color.GREEN);
        }
    }

}