import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Test extends Application{
    @Override
    public void start(Stage primaryStage) {
        ArrayList<SemiCircleChart.Data> dataList = new ArrayList<SemiCircleChart.Data>();

        dataList.add(new SemiCircleChart.Data("data1", 1, Color.RED));
        dataList.add(new SemiCircleChart.Data("data2", 2, Color.GREEN));
        dataList.add(new SemiCircleChart.Data("data3", 3, Color.BLUE));

        SemiCircleChart chart = new SemiCircleChart(dataList, 500, 500, 500,100,2);

        Pane pane = new Pane(chart);
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}