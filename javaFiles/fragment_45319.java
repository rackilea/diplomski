import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.SwingUtilities;
public class GlueMenuBarTest
{
    public static void main (String [] a) {
        SwingUtilities.invokeLater (new Runnable () {
            @Override public void run () {
                createAndShowGUI ();
            }
        });
    }
    private static void createAndShowGUI () {
        JFrame frame = new JFrame ("Test");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar (createGlueMenuBar ());
        frame.setSize (500, 250); // just for convenience, use pack () in a real app.
        frame.setLocationRelativeTo (null);
        frame.setVisible (true);
    }
    private static JMenuBar createGlueMenuBar () {
        JMenuBar menuBar = new JMenuBar ();
        menuBar.add (new JMenu ("File"));
        menuBar.add (new JMenu ("Edit"));
        menuBar.add (new JMenu ("Search"));
        menuBar.add (Box.createHorizontalGlue ());
        menuBar.add (new JMenu ("Help"));
        return menuBar;
    }
}