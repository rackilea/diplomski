public class Dimensions extends Application {

    public static void main(String[] args) { 
        launch(args);
    }

    public void start(Stage primaryStage) {
        MyPanel myPanel = new MyPanel();
        primaryStage.setScene(new Scene(myPanel, 500, 500));
        primaryStage.show();

        System.out.println(myPanel.label.getWidth());
    }
}

class MyPanel extends Pane {
    public Label label;

    public MyPanel() {

        label = new Label();
        label.setText("Hello");
        label.setFont(new Font(32));
        getChildren().add(label);
        label.relocate(150, 150);
    }
}