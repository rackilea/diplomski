private ObservableList<Anchor> createControlAnchorsFor(Polygon polygon, final ObservableList<Double> points) {
    ...

    Anchor anchor = new Anchor(Color.GOLD, xProperty, yProperty);

    anchor.layoutXProperty().bind(polygon.layoutXProperty());
    anchor.layoutYProperty().bind(polygon.layoutYProperty());

    anchors.add(anchor);

    ...

}