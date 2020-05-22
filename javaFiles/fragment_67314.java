CategoryMarker marker = new CategoryMarker("Category 3");
marker.setLabel("Band Y");
marker.setPaint(Color.red);
marker.setOutlinePaint(Color.red);
marker.setAlpha(0.5f);
marker.setLabelAnchor(RectangleAnchor.TOP);
marker.setLabelTextAnchor(TextAnchor.TOP_CENTER);
marker.setLabelOffsetType(LengthAdjustmentType.CONTRACT);
plot.addDomainMarker(marker, Layer.BACKGROUND);