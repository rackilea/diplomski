private Measure<Double, Area> calcArea(Polygon p) {
    try {
      String code = "EPSG:2163";
      CoordinateReferenceSystem auto = CRS.decode(code);

      MathTransform transform = CRS.findMathTransform(DefaultGeographicCRS.WGS84, auto);

      Polygon projed = (Polygon) JTS.transform(p, transform);
      return Measure.valueOf(projed.getArea(), SI.SQUARE_METRE);
    } catch (MismatchedDimensionException | TransformException | FactoryException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return Measure.valueOf(0.0, SI.SQUARE_METRE);
  }