final Marker start = new ValueMarker(3400000.0);
    start.setPaint(Color.red);
    start.setLabel("Current Value");
    start.setLabelAnchor(RectangleAnchor.BOTTOM_LEFT);
    start.setLabelTextAnchor(TextAnchor.TOP_LEFT);
    plot.addRangeMarker(start);