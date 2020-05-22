public class ZoomableCanvas extends Pane {

    DoubleProperty scale = new SimpleDoubleProperty(1.0);

    public ZoomableCanvas() {
        scaleXProperty().bind(scale);
        scaleYProperty().bind(scale);

        getChildren().addListener((Change<? extends Node> c) -> {
            while (c.next()) {
                if (c.wasAdded()) {
                    for (Node child : c.getAddedSubList()) {
                        child.scaleXProperty().bind(scale);
                        child.scaleYProperty().bind(scale);
                    }
                }
                if (c.wasRemoved()) {
                    for (Node child : c.getRemoved()) {
                        child.scaleXProperty().unbind();
                        child.scaleYProperty().unbind();
                    }
                }
            }
        });
    }

    public double getScale() {
        return scale.get();
    }

    public void setScale(double scale) {
        this.scale.set(scale);
    }

    public void setPivot(double x, double y) {
        setTranslateX(getTranslateX() - x);
        setTranslateY(getTranslateY() - y);
    }
}