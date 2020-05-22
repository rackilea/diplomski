import java.awt.ComponentOrientation;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class TestTabbedPane extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTabbedPane tabbedPane;

    public TestTabbedPane() {
        tabbedPane = new JTabbedPane();
        tabbedPane.setPreferredSize(new Dimension(300, 200));
        getContentPane().add(tabbedPane);
        JPanel panel = new JPanel();
        tabbedPane.add(panel, "null");
        JTextField one = new JTextField("one");
        tabbedPane.add(one, "one");
        JTextField two = new JTextField("two");
        //tabbedPane.add(two, "<html> T<br>i<br>t<br>t<br>l<br>e <br> 1 </html>");
        tabbedPane.add(two, "<html> Tittle  1 </html>");
        tabbedPane.setEnabledAt(2, false);
        tabbedPane.setTitleAt(2, "<html><font color="
                + (tabbedPane.isEnabledAt(2) ? "black" : "red") + ">"
                + tabbedPane.getTitleAt(2) + "</font></html>");
        tabbedPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        tabbedPane.setTabPlacement(JTabbedPane.BOTTOM);
    }

    public static void main(String args[]) {
        TestTabbedPane frame = new TestTabbedPane();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}