XYStepRenderer renderer = new XYStepRenderer();
  renderer.setBaseShapesVisible(true);
  renderer.setSeriesStroke(0, new BasicStroke(2.0f));
  renderer.setSeriesStroke(1, new BasicStroke(2.0f));
  renderer.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
  renderer.setDefaultEntityRadius(6);
  plot.setRenderer(renderer);