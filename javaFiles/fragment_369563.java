for (Data<X, Y> horizontalMarker : horizontalMarkers) {
        Line line = (Line) horizontalMarker.getNode();
        line.setStartX(0);
        line.setEndX(getBoundsInLocal().getWidth());
        line.setStartY(getYAxis().getDisplayPosition(horizontalMarker.getYValue()) + 0.5); // 0.5 for crispness
        line.setEndY(line.getStartY());
        line.toFront();

        Node text = nodeMap.get(line);
        text.relocate(line.getBoundsInParent().getMinX() + line.getBoundsInParent().getWidth()/2 - text.prefWidth(-1) / 2, line.getBoundsInParent().getMinY() - 30);
    }