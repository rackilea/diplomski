import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MinimizeButton extends Button {
    /**
     * 
     * @param img the image when the button is NOT selected
     * @param imgHover the image when button is selected
     * @param stage the stage that will be minimized
     */
    public MinimizeButton(Image img, Image imgHover, Stage stage) {
        ImageView imgView = new ImageView(img);
        this.setGraphic(imgView);
        this.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            imgView.setImage(imgHover);
        });

        this.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            imgView.setImage(img);
        });

        this.setOnAction((ActionEvent event) -> {
            stage.setIconified(true);
            imgView.setImage(img);
        });
    }
}