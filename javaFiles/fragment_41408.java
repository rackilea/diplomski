import java.awt.*;
import javax.swing.*;

public class FrameInfo
{
    public static void main(String[] args)
    {
        String laf = "javax.swing.plaf.metal.MetalLookAndFeel";
//        laf = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
//        laf = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";

//        try { UIManager.setLookAndFeel( laf ); }
//        catch (Exception e) { System.out.println(e); }
//        JFrame.setDefaultLookAndFeelDecorated(true);

        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle bounds = env.getMaximumWindowBounds();
        System.out.println("Screen Bounds: " + bounds );

        GraphicsDevice screen = env.getDefaultScreenDevice();
        GraphicsConfiguration config = screen.getDefaultConfiguration();
        System.out.println("Screen Size  : " + config.getBounds());
        System.out.println(Toolkit.getDefaultToolkit().getScreenSize());

        JFrame frame = new JFrame("Frame Info");
        System.out.println("Frame Insets : " + frame.getInsets() );

        frame.setSize(200, 200);
//        frame.pack();
        System.out.println("Frame Insets : " + frame.getInsets() );
        frame.setVisible( true );

        System.out.println("Frame Size   : " + frame.getSize() );
        System.out.println("Frame Insets : " + frame.getInsets() );
        System.out.println("Content Size : " + frame.getContentPane().getSize() );
     }
}