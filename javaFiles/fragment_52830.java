import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Lab8 extends Application {

    private Pane pane;

    @Override
    public void start(Stage primaryStage) throws Exception {
        pane = new Pane();

        int pwidth = 425;
        int pheight = 425;
        int cx = 210;
        int cy = 210;

        Rectangle r = new Rectangle();
        r.setX(0);
        r.setY(0);
        r.setWidth(pwidth);
        r.setHeight(pheight);
        r.setFill(Color.web("#00ffff"));
        pane.getChildren().add(r);  

        Ellipse c0 = new Ellipse(cx,cy,205,205);
        c0.setFill(Color.WHITE);
        c0.setStroke(Color.BLACK);
        pane.getChildren().add(c0);

        c0 = new Ellipse(cx,cy,185,185);
        c0.setFill(Color.WHITE);
        c0.setStroke(Color.BLACK);
        pane.getChildren().add(c0);     

        c0 = new Ellipse(cx,cy,165,165);
        c0.setFill(Color.BLACK);
        c0.setStroke(Color.WHITE);
        pane.getChildren().add(c0);     

        c0 = new Ellipse(cx,cy,145,145);
        c0.setFill(Color.BLACK);
        c0.setStroke(Color.WHITE);
        pane.getChildren().add(c0);                 

        c0 = new Ellipse(cx,cy,125,125);
        c0.setFill(Color.BLUE);
        c0.setStroke(Color.BLACK);
        pane.getChildren().add(c0); 

        c0 = new Ellipse(cx,cy,105,105);
        c0.setFill(Color.BLUE);
        c0.setStroke(Color.BLACK);
        pane.getChildren().add(c0); 

        c0 = new Ellipse(cx,cy,85,85);
        c0.setFill(Color.RED);
        c0.setStroke(Color.BLACK);
        pane.getChildren().add(c0); 

        c0 = new Ellipse(cx,cy,65,65);
        c0.setFill(Color.RED);
        c0.setStroke(Color.BLACK);
        pane.getChildren().add(c0); 

        c0 = new Ellipse(cx,cy,45,45);
        c0.setFill(Color.YELLOW);
        c0.setStroke(Color.BLACK);
        pane.getChildren().add(c0); 

        c0 = new Ellipse(cx,cy,25,25);
        c0.setFill(Color.YELLOW);
        c0.setStroke(Color.BLACK);
        pane.getChildren().add(c0); 

        c0 = new Ellipse(cx,cy,5,5);
        c0.setFill(Color.BLACK);
        c0.setStroke(Color.WHITE);
        pane.getChildren().add(c0);         

        Scene scene = new Scene(pane,pwidth,pheight);
        primaryStage.setTitle("Target");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                //stage is closing
                System.out.println("Bye.");
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}