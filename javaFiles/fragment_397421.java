import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.stage.Stage;

public class AOE extends Application {
    @Override public void start(final Stage stage) throws Exception {
        stage.setScene(
            new Scene(
                new Group(
                    new ImageView(
                        new Image(
                            "http://ageofempiresgif.altervista.org/33995109.gif"
                        )
                    )
                )
            )
        );
        stage.show();
    }

    public static void main(String[] args) { launch(AOE.class); }
}