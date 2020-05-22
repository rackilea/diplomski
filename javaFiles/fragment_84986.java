public void createScene() {
    createSurface();
    group.getChildren().addAll(surface);

    perspectiveCamera.setNearClip(0.1);
    perspectiveCamera.setFarClip(100000.0);
    perspectiveCamera.setTranslateX((group.getBoundsInLocal().getMaxX() + group.getBoundsInLocal().getMinX()) / 2d);
    perspectiveCamera.setTranslateY((group.getBoundsInLocal().getMaxY() + group.getBoundsInLocal().getMinY()) / 2d);
    double max = Math.max(group.getBoundsInLocal().getWidth(), group.getBoundsInLocal().getHeight());
    perspectiveCamera.setTranslateZ(-2 * max);
}