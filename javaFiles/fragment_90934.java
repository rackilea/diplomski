@Override
public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("ImageView Experiment 1");

    String imgUrl = "https://s5.gifyu.com/images/test222466041f4e8599a.gif";
    URLConnection connection = new URL(imgUrl).openConnection();
    connection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
    Image image = new Image(connection.getInputStream());
    ImageView imageView = new ImageView();
    imageView.setImage(image);

    HBox hbox = new HBox(imageView);

    Scene scene = new Scene(hbox, 200, 200);
    primaryStage.setScene(scene);
    primaryStage.show();

}

public static void main(String[] args) {
    Application.launch(args);
}