public class IterateThrough2 extends Application{
  private Desktop desktop = Desktop.getDesktop();
  @Override
  public void start(Stage primaryStage) throws IOException{
    File dir = new File("filepath");
    File[] directoryListing = dir.listFiles();

    FlowPane root = new FlowPane();

    if(directoryListing != null){
      for(File file : directoryListing){
        if(file.getName().toLowerCase().endsWith(".jpeg")){
          Image image = new Image(new FileInputStream(file));
          ImageView imageView = new ImageView(image);
          imageView.setFitHeight(600);
          imageView.setFitWidth(500);
          imageView.setPreserveRatio(true);
          MotionBlur motionBlur = new MotionBlur();
          motionBlur.setRadius(15.0);
          motionBlur.setAngle(110.0);
          imageView.setEffect(motionBlur);
          root.getChildren().add(imageView);
        }
      }
    }

    Scene scene = new Scene(root, 600, 500);
    primaryStage.setTitle("Loading an image");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args){
    launch(args);
  }
}