import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.SnapshotParameters;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import javax.swing.SwingUtilities;
import java.awt.image.BufferedImage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/** Uses JavaFX to adjust the color of an AWT/Swing BufferedImage */
public class ColorAdjuster {
    // Instantiation of a JFXPanel is necessary otherwise the JavaFX toolkit is not initialized.
    // The JFXPanel doesn't actually need to be used, instantiating it in the constructor is enough to trigger toolkit initialization.
    private final JFXPanel fxPanel;

    public ColorAdjuster() {
        // perhaps this check is not necessary, but I feel a bit more comfortable if it is there.
        if (!SwingUtilities.isEventDispatchThread()) {
            throw new IllegalArgumentException(
                    "A ColorAdjuster must be created on the Swing Event Dispatch thread.  " +
                            "Current thread is " + Thread.currentThread()
            );
        }

        fxPanel = new JFXPanel();
    }

    /** 
     * Color adjustments to the buffered image are performed with parameters in the range -1.0 to 1.0
     * 
     * @return a new BufferedImage which has colors adjusted from the original image.
     **/
    public BufferedImage adjustColor(
            BufferedImage originalImage,
            double hue,
            double saturation,
            double brightness,
            double contrast
    ) throws ExecutionException, InterruptedException {
        // This task will be executed on the JavaFX thread.
        FutureTask<BufferedImage> conversionTask = new FutureTask<>(() -> {
            // create a JavaFX color adjust effect.
            final ColorAdjust monochrome = new ColorAdjust(0, -1, 0, 0);

            // convert the input buffered image to a JavaFX image and load it into a JavaFX ImageView.
            final ImageView imageView = new ImageView(
                    SwingFXUtils.toFXImage(
                            originalImage, null
                    )
            );

            // apply the color adjustment.
            imageView.setEffect(monochrome);

            // snapshot the color adjusted JavaFX image, convert it back to a Swing buffered image and return it.
            SnapshotParameters snapshotParameters = new SnapshotParameters();
            snapshotParameters.setFill(Color.TRANSPARENT);

            return SwingFXUtils.fromFXImage(
                    imageView.snapshot(
                            snapshotParameters,
                            null
                    ),
                    null
            );
        });

        Platform.runLater(conversionTask);

        return conversionTask.get();
    }
}