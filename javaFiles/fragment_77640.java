private TranslateTransition createNextTransition(Node myObject) {
    // some updates...
    TranslateTransition tt = new TranslateTransition(Duration.millis(2000), myObject);
    tt.setOnFinished(e -> {
        if (condition) {
            createNextTransition(myObject);
        }
    });
    tt.play();
}