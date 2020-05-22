import java.awt.Frame;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class CloseAWT
{
    private static boolean running = true;
    private static int response = -1;

    public static void main(String[] args)
    {
        boolean showSwing = true;
        boolean checkFrames = true;
        while (running)
        {
            if (showSwing)
            {
                SwingUtilities.invokeLater(new Runnable()
                {
                    public void run()
                    {
                        response = JOptionPane.showConfirmDialog(null, "Hello World?");
                    }
                });
                showSwing = false;
            }
            else
            {
                if (response >= 0 && checkFrames)
                {
                    SwingUtilities.invokeLater(new Runnable()
                    {
                        public void run()
                        {
                            // topFrame.dispose();
                            Frame[] frames = Frame.getFrames();
                            System.out.printf("frames.length=%d\n", frames.length);
                        }
                    });
                    checkFrames = false;
                }
            }
        }
    }
}