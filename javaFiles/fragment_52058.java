public void signUpScene(MouseEvent mouseEvent) throws IOException {
        Scene SignUpScene = new Scene(FXMLLoader.load(getClass().getResource("sign up.fxml")),700,700);
        Main.pstage.setScene(SignUpScene);

        Rectangle clip = new Rectangle(0, 700);

        Transition animateStage = new Transition() {
            {
                setCycleDuration(Duration.millis(1000));
            }
            @Override
            protected void interpolate(double t) {
                Main.pstage.setWidth(t * 700.0);
            }
        };
        animateStage.play();
    }
}