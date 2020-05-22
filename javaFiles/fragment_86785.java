import javafx.application.Platform;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class ColorAdjustingSwingAppUsingJavaFX {

    private static void initAndShowGUI() {
        try {
            // This method is invoked on Swing thread
            JFrame frame = new JFrame();

            // read the original image from a URL.
            URL url = new URL(
                    IMAGE_LOC
            );
            BufferedImage originalImage   = ImageIO.read(url);

            // use JavaFX to convert the original image to monochrome.
            ColorAdjuster colorAdjuster = new ColorAdjuster();
            BufferedImage monochromeImage = colorAdjuster.adjustColor(
                    originalImage,
                    0, -1, 0, 0
            );

            // add the original image and the converted image to the Swing frame.
            frame.getContentPane().setLayout(new FlowLayout());
            frame.getContentPane().add(
                    new JLabel(
                            new ImageIcon(originalImage)
                    )
            );
            frame.getContentPane().add(
                    new JLabel(
                            new ImageIcon(monochromeImage)
                    )
            );

            // set a handler to close the application on request.
            frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    // shutdown the JavaFX runtime.
                    Platform.exit();

                    // exit the application.
                    System.exit(0);
                }
            });

            // display the Swing frame.
            frame.pack();
            frame.setLocation(400, 300);
            frame.setVisible(true);
        } catch (IOException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                ColorAdjustingSwingAppUsingJavaFX::initAndShowGUI
        );
    }


    // icon source: http://www.iconarchive.com/artist/aha-soft.html
    // icon license: Free for non-commercial use, commercial usage: Not allowed
    private static final String IMAGE_LOC =
            "http://icons.iconarchive.com/icons/aha-soft/desktop-buffet/128/Pizza-icon.png";
}