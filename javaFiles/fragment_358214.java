public class Main extends Application {

private SimpleIntegerProperty rowProperty = new SimpleIntegerProperty(4); //default
private SimpleIntegerProperty columnProperty = new SimpleIntegerProperty(6);//default


@Override
public void start(Stage primaryStage) {
    try {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(5));
        HBox top;
        TextField rowField = new TextField();
        rowField.setMaxWidth(60);
        rowField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {
                try{ rowProperty.setValue(Integer.valueOf(newValue));}catch(NumberFormatException e){}
            }
        });
        TextField colField = new TextField();
        colField.setMaxWidth(60);
        colField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {
                try{ columnProperty.setValue(Integer.valueOf(newValue));}catch(NumberFormatException e){}
            }
        });
        top = new HBox(10,new Label("ROW FIELD"),rowField, new Label("COLUMN FIELD"),colField);
        top.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: white;");
        root.setTop(top);
        ////////////////////////////////////////////////////////////////////////////////////
        Canvas canvas = new Canvas(500,400);
        canvas.getGraphicsContext2D().setFill(Color.BLACK);
        canvas.getGraphicsContext2D().setStroke(Color.GOLD);

        ChangeListener<Number> chan = new ChangeListener<Number>() {
            int space = 2;
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                    Number oldValue, Number newValue) {
                ///i will draw here
                canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                int rectW = (int) canvas.getWidth();
                rectW = rectW/columnProperty.intValue();
                int rectH = (int) canvas.getHeight();
                rectH = rectH/rowProperty.intValue();

                System.out.println(rectW);
                System.out.println(rectH);

                for(int k = 0; k < canvas.getHeight()/rectH; k++){
                    for(int i =0; i< canvas.getWidth()/rectW; i++){
                        canvas.getGraphicsContext2D().fillRect((i*rectW) + (i*space),
                                (k*rectH) + (k*space),
                                rectW, rectH);
                    }
                }

            }
        };
        rowProperty.addListener(chan);
        columnProperty.addListener(chan);
        //////////////////////////////////////////////////////////////////////////////////////////

        root.setCenter(canvas);
        Label l = new Label("ENTER NUMBERS TO FIELDS TO SEE IT");
        l.setStyle("-fx-background-color: blueviolet; -fx-text-fill: white;");
        l.setPrefWidth(Double.MAX_VALUE);
        l.setAlignment(Pos.CENTER);
        root.setBottom(l);
        Scene scene = new Scene(root,500,500);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();

    } catch(Exception e) { e.printStackTrace(); }
}



public static void main(String[] args) {
    launch(args);
}