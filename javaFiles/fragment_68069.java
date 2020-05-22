Timeline timeline = new Timeline(
            new KeyFrame(Duration.seconds(5), e -> {
                Dialog< Void> dialog = new Dialog<>();
                dialog.setTitle( "Image");
                dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);

                ImageView view = new ImageView("https://upload.wikimedia.org/wikipedia/commons/1/11/Cheetah_Kruger.jpg");

                ScrollPane root = new ScrollPane( view);
                root.setPrefWidth( 800);
                root.setPrefHeight( 600);

                dialog.getDialogPane().setContent( root);
                dialog.setResizable( true);
                dialog.show();
            })
        );
    timeline.setCycleCount(Animation.INDEFINITE);
    timeline.play();