public class Main extends Application {

@Override
public void start(Stage primaryStage) throws Exception{
    form1().show();
    form2().show();
}


public static void main(String[] args) {
    launch(args);
}

private Stage form1(){
    Stage stage=new Stage();
    stage.setTitle("Window 1");
    stage.setScene(new Scene(new Group(new Button("Window 1"))));
    return stage;
}
private Stage form2(){
       Stage stage=new Stage();
       stage.setTitle("Window 2");
       stage.setScene(new Scene(new Group(new Button("Window 2"))));
       return stage;
   }



}