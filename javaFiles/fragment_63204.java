private void recalculateTransition() {
    transition.setToX(node.getBoundsInLocal().getMaxX() * -1 - 100);
    transition.setFromX(parentPane.widthProperty().get() + 100);

    double distance = parentPane.widthProperty().get() + 2 * node.getBoundsInLocal().getMaxX();
    transition.setDuration(new Duration(distance / SPEED_FACTOR));
}