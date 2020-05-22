{
  CategoryMarker marker = new CategoryMarker("Category 2");
  marker.setLabel("Band X");
  marker.setLabelAnchor(RectangleAnchor.TOP);
  marker.setLabelTextAnchor(TextAnchor.TOP_CENTER);
  marker.setLabelOffsetType(LengthAdjustmentType.CONTRACT);
  plot.addDomainMarker(marker, Layer.BACKGROUND);
  }
  {
  CategoryMarker marker = new CategoryMarker("Category 3");
  plot.addDomainMarker(marker, Layer.BACKGROUND);
  }
  renderer.setItemMargin(0.0);
  CategoryAxis axis = plot.getDomainAxis();
  axis.setCategoryMargin(0);
}