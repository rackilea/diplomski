import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;
import java.awt.image.DirectColorModel;
import java.awt.image.PixelGrabber;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;

public class JPEGProblem extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage window) throws Exception {
        BufferedImage bi = getBufferedImage();
        ImageView imgView = getFinalImageView(bi);
        window.setScene(new Scene(new Pane(imgView)));
        window.show();
    }

    private BufferedImage getBufferedImage() throws InterruptedException {
        final java.awt.Image image = Toolkit.getDefaultToolkit().createImage("path\to\file");

        final int[] RGB_MASKS = {0xFF0000, 0xFF00, 0xFF};
        final ColorModel RGB_OPAQUE =
                new DirectColorModel(32, RGB_MASKS[0], RGB_MASKS[1], RGB_MASKS[2]);

        PixelGrabber pg = new PixelGrabber(image, 0, 0, -1, -1, true);
        pg.grabPixels();
        int width = pg.getWidth(), height = pg.getHeight();
        DataBuffer buffer = new DataBufferInt((int[]) pg.getPixels(), pg.getWidth() * pg.getHeight());
        WritableRaster raster = Raster.createPackedRaster(buffer, width, height, width, RGB_MASKS, null);
        return new BufferedImage(RGB_OPAQUE, raster, false, null);
    }

    private ImageView getFinalImageView(BufferedImage bi) throws Exception {
        ImageView imgView = new ImageView(SwingFXUtils.toFXImage(bi, null));
        imgView.setFitWidth(1024);
        imgView.setFitHeight(756);
        imgView.setRotate(180);
        return imgView;
    }
}