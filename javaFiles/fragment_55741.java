public class MainClass extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
              AnchorPane group = new AnchorPane();   
              Scene scene = new Scene(group ,600, 300);  
              primaryStage.setTitle("Sample Application"); 
              primaryStage.setScene(scene); 
              FlowPane flowPane = new FlowPane();
              System.out.println("log:brows song");
              for (int i = 0; i < 10; i++) {
                  Image image = new Image(new File("2.jpg").toURI().toString());
                  ImageView imageView = new ImageView(image);
                  flowPane.getChildren().add(imageView);
              }
              group.getChildren().clear();

              group.getChildren().add(flowPane);
              primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
  public static void main(String[] args) {
      launch(args);
  }

}