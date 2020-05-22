//BorderPane()
        //https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/BorderPane.html
        BorderPane borderPane = new BorderPane();

        //jot down the width and height of the scene
        double width = 600;
        double height = 600;

        //Image(InputStream is)
        //https://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/Image.html
        Image img = new Image(file.getAbsoluteFile().toURI().toString());
        ImageView background = new ImageView(img);
        //..center the background
        double translateX = width/2 - img.getWidth()/2;
        background.setTranslateX(translateX);

        //Button(String text)
        //https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Button.html
        Button btn = new Button("Center");

        //https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/BorderPane.html#setCenter-javafx.scene.Node-
        borderPane.setCenter(btn);

        //make root with BorderPane and background image
        Group root = new Group (background, borderPane);

        Scene scene = new Scene(root, width, height);