Image image = new Image(Main.class.getResource("/texture.png").toExternalForm());
BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
        BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.AUTO);
Background background = new Background(backgroundImage);

Button button = new Button("Button");
button.setBackground(background);