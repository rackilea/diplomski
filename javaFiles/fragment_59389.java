import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ImagePrinter extends Application {

  @Override
  public void start(Stage primaryStage) {

    Image image = new Image("http://www.gnu.org/graphics/gnu-head.png");
    BufferedImage bufferedImage = SwingFXUtils.fromFXImage(image, null);

    Button btn = new Button();
    btn.setText("Print Image");
    btn.setOnAction(new EventHandler<ActionEvent>() {

      @Override
      public void handle(ActionEvent event) {
        printImage(bufferedImage);
      }
    });

    StackPane root = new StackPane();
    root.getChildren().add(btn);

    Scene scene = new Scene(root, 300, 250);

    primaryStage.setTitle("Image Printer");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }

  private void printImage(BufferedImage image) {
    PrinterJob printJob = PrinterJob.getPrinterJob();
    printJob.setPrintable(new Printable() {
      @Override
      public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        // Get the upper left corner that it printable
        int x = (int) Math.ceil(pageFormat.getImageableX());
        int y = (int) Math.ceil(pageFormat.getImageableY());
        if (pageIndex != 0) {
          return NO_SUCH_PAGE;
        }
        graphics.drawImage(image, x, y, image.getWidth(), image.getHeight(), null);
        return PAGE_EXISTS;
      }
    });
    try {
      printJob.print();
    } catch (PrinterException e1) {
      e1.printStackTrace();
    }
  }
}