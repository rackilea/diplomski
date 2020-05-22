import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class TextFlowInScrollPane extends Application {


    @Override
    public void start(Stage primaryStage) {
        TextFlow flow = new TextFlow(new Text(text));
        VBox vbox = new VBox(flow);
        ScrollPane scrollPane = new ScrollPane(vbox);

        // removing this line will allow the scroll pane to grow
        // to an unlimited width, and so will prevent the text from
        // wrapping:
        scrollPane.setFitToWidth(true);

        Scene scene = new Scene(scrollPane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private final String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
            + "Duis malesuada nisi non est varius convallis. Donec eu aliquam tellus. "
            + "Duis nulla nulla, mattis non dictum non, bibendum vel eros. "
            + "Cras auctor metus eros, quis porta nisi mattis at. "
            + "Aenean bibendum, elit nec suscipit imperdiet, lorem mauris cursus felis, "
            + "sed suscipit quam nibh faucibus dui. Ut vel condimentum enim. "
            + "Curabitur non lacinia nunc. Quisque ut arcu turpis. Maecenas enim risus, "
            + "cursus eget auctor at, volutpat condimentum ligula. "
            + "Aliquam rutrum consectetur sapien, non imperdiet nisi auctor quis. "
            + "In hac habitasse platea dictumst. Nulla eget lacus ac quam dignissim varius. "
            + "In hac habitasse platea dictumst. Proin quis pellentesque eros, nec semper nibh."
            + "Integer venenatis aliquam risus volutpat tempor. Aliquam erat volutpat. "
            + "Proin at viverra turpis. Sed luctus purus tortor, ut molestie libero tempus quis. "
            + "Nulla eu viverra nulla. Vivamus ut bibendum lectus, eu lobortis tellus. "
            + "Aliquam pellentesque ipsum ipsum. Sed vel pellentesque sapien, ut egestas arcu. "
            + "Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. "
            + "Curabitur sodales felis at justo congue pharetra. "
            + "Curabitur sodales, urna a pulvinar consectetur, urna dolor rhoncus turpis, vel dapibus neque nisl a leo. "
            + "Maecenas feugiat consequat tortor fermentum molestie. Donec a est et risus porttitor ornare. "
            + "Cras auctor metus sed maximus fringilla. Donec blandit augue eu orci elementum malesuada. "
            + "Aliquam volutpat, enim at lacinia sollicitudin, nibh nisi dignissim erat, "
            + "sit amet accumsan orci lorem vitae nibh."
            + "Maecenas interdum finibus laoreet. Mauris iaculis nibh nec dui lacinia, ut lacinia est venenatis. "
            + "Donec vitae varius eros. Phasellus scelerisque eu risus ac bibendum. "
            + "Morbi luctus, diam ut vehicula tristique, lacus mi ornare lacus, nec hendrerit nulla metus vitae mauris. "
            + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas mattis luctus nisl non volutpat. "
            + "Aenean euismod tristique libero sit amet dictum. Nulla facilisi. Aenean posuere dapibus convallis."
            + "In vulputate mi quam, ut mattis felis iaculis sed. Phasellus eleifend nunc ex, "
            + "vel commodo diam dictum at. Quisque posuere arcu ut lectus bibendum, non dapibus turpis luctus. "
            + "Nullam quis arcu elit. In convallis rutrum nulla nec feugiat. Curabitur dapibus accumsan quam, "
            + "ut faucibus orci posuere rhoncus. Integer vestibulum ex vitae sem elementum, a laoreet odio porta. "
            + "Suspendisse malesuada cursus euismod. Duis a arcu erat. Integer eu nisi quis lectus convallis suscipit."
            + "Pellentesque iaculis leo at dolor accumsan, nec fermentum urna maximus. "
            + "Aenean ornare congue nisi, nec placerat ipsum. Morbi et pharetra turpis, vel accumsan lorem. "
            + "Aenean tempus maximus velit, sed rutrum purus condimentum nec. Nunc sed aliquet turpis, ac aliquam justo. "
            + "Curabitur lectus urna, facilisis ac sapien vel, lacinia pulvinar mauris. "
            + "Cras venenatis, sapien maximus tincidunt luctus, lectus est auctor leo, id facilisis dui ex a ipsum. "
            + "Duis a urna sed purus semper maximus accumsan non mi. "
            + "Phasellus pharetra tempus sapien, in congue nisi ornare sed. "
            + "Sed mollis, velit eu eleifend elementum, nisi lacus venenatis erat, "
            + "pellentesque pulvinar augue diam eu ex. Maecenas non lacus mauris."
            + "Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. "
            + "Nam maximus eros urna. Vestibulum tempus condimentum nunc sit amet laoreet.";


}