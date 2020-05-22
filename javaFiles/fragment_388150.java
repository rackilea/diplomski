private void makeShadeableByInnerShadow(Scene scene) {
    InnerShadow shade = new InnerShadow();
    shade.setWidth(120);
    shade.setHeight(120);
    shade.setInput(new ColorAdjust(0, 0, -0.3, 0));

    Parent root = scene.getRoot();
    scene.setOnMouseClicked(event -> {
        if (root.getEffect() == null) {
            root.setEffect(shade);
        } else {
            root.setEffect(null);
        }
    });
}