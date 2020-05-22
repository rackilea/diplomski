import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ScrollTesting {

    private JPanel panel = new JPanel();
    private JScrollPane scrollPane = new JScrollPane(panel);
    private Vector<JTextField> fieldsVector = new Vector<JTextField>();
    private Dimension preferredSize = new Dimension(400, 40);
    private Font font = new Font("Tahoma", 1, 28);

    public ScrollTesting() {
        panel.setLayout(new GridLayout(100, 1));
        for (int i = 0; i < 100; i++) {
            fieldsVector.addElement(new JTextField());
            fieldsVector.lastElement().setPreferredSize(preferredSize);
            fieldsVector.lastElement().setFont(font);
            panel.add(fieldsVector.lastElement());
        }
        JFrame frame = new JFrame();
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(scrollPane);
        frame.setVisible(true);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JTextField tf = (JTextField) fieldsVector.lastElement();
                panel.scrollRectToVisible(tf.getBounds());
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ScrollTesting scrollTesting = new ScrollTesting();
            }
        });
    }
}