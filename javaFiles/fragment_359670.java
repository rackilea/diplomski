import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class SomeSwingGUI
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                createAndShowGUI();
            }
        });
    }

    // This method may (and will) only be called
    // on the Event Dispatch Thread
    private static void createAndShowGUI()
    {
        JFrame f = new JFrame();

        // Add your components here        

        f.setVisible(true); // Do this last
    }
}