public void signUpScene(MouseEvent mouseEvent) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("sign up.fxml"));

        Scene SignUpScene = new Scene(root,700,700);
        Main.pstage.setScene(SignUpScene);

        Rectangle clip = new Rectangle(0, 700);
        Timeline animate = new Timeline(
           new KeyFrame(Duration.millis(1000), 
               new KeyValue(clip.widthProperty(), 700.0));
        root.setClip(clip);
        // when animation finishes, remove clip:
        animate.setOnFinished(e -> root.setClip(null));
        animate.play();
    }
}