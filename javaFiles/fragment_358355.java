private final BorderPane rootPane = new BorderPane(); // Class field

// in your start method
final Scene scene = new Scene(rootPane);
primaryStage.setScene(scene);

//Change View like this:
View v = new BView();
rootPane.setCenter(v.getRec());

// later you can set your color
v.setColor()


// Your View class:
public class View{
    private Rectangle rect;

    public View(){
      rect = new Rectangle(10, 10, 100, 100); 
      rect.setFill(Color.WHITE);            
      rect.setStroke(Color.BLACK);
    }

    public Rectangle getRec(){
        return this.rect;
    }
}