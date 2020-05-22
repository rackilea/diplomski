import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
public class Test
{
    public static void main (String [] a) {
        SwingUtilities.invokeLater (new Runnable () {
            @Override public void run () {
                createAndShowGUI ();
            }
        });
    }
    private static void createAndShowGUI () {
        JFrame frame = new JFrame ("Test Application");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.setContentPane (new MainPanel ());

        // This instruction is used for convenience to let you see the final result, use pack () on your application.
        frame.setSize (800, 600);  
        // frame.pack ();

        frame.setLocationRelativeTo (null);
        frame.setVisible (true);
    }
}
class MainPanel extends JPanel
{
    public MainPanel () {
        super (new BorderLayout ());

        JPanel left = new JPanel (new GridLayout (4, 1));
        for (int i = 1; i <= 4; i ++) left.add (new JButton ("Button " + i));

        JPanel center = new JPanel (new BorderLayout ());

        JMenuBar menuBar = new JMenuBar ();
        JMenu fileMenu = new JMenu ("File Menu", true);
        menuBar.add (fileMenu);
        center.add (menuBar, BorderLayout.NORTH);

        JPanel labelsPanel = new JPanel (new GridBagLayout ());
        labelsPanel.add (new JLabel ("Label 1"));

        GridBagConstraints c = new GridBagConstraints ();
        c.gridy = 1;
        c.insets = new Insets (5, 0, 0, 0);
        labelsPanel.add (new JLabel ("Label 2"), c);

        center.add (labelsPanel, BorderLayout.CENTER);

        JPanel right = new JPanel (new GridLayout (4, 1));
        for (int i = 5; i <= 8; i ++) right.add (new JButton ("Button " + i));

        add (left, BorderLayout.WEST);
        add (center, BorderLayout.CENTER);
        add (right, BorderLayout.EAST);
    }
}