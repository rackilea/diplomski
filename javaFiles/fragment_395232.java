Pane root = new Pane();

    Scene scene = new Scene(root, 300, 250);

    Line lineScal = new Line(0, 50, 600, 50);
    lineScal.setStroke(Color.LIGHTBLUE);
    for (int i = 600; i >= 0; i = i - 50)

    {

        Line line1 = new Line(i, 50, i, 30);

        Text scaleText = new Text(i, 20, Double.toString(i));
        line1.setStroke(Color.LIGHTGRAY);

        root.getChildren().addAll(line1,scaleText);

    }

    root.getChildren().add(lineScal);
    primaryStage.setTitle("Hello World!");
    primaryStage.setScene(scene);
    primaryStage.show();
}

/**
 * @param args the command line arguments
 */
public static void main(String[] args)
{
    launch(args);
}