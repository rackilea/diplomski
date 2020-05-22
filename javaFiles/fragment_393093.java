public Geometry bufferPoint(Measure<Double, Length> distance, CoordinateReferenceSystem origCRS, Geometry geom) {
    Geometry pGeom = geom;
    MathTransform toTransform, fromTransform = null;
    // reproject the geometry to a local projection
    Unit<Length> unit = distance.getUnit();
    if (!(origCRS instanceof ProjectedCRS)) {

      double x = geom.getCoordinate().x;
      double y = geom.getCoordinate().y;

      String code = "AUTO:42001," + x + "," + y;
      // System.out.println(code);
      CoordinateReferenceSystem auto;
      try {
        auto = CRS.decode(code);
        toTransform = CRS.findMathTransform(DefaultGeographicCRS.WGS84, auto);
        fromTransform = CRS.findMathTransform(auto, DefaultGeographicCRS.WGS84);
        pGeom = JTS.transform(geom, toTransform);
        unit = SI.METER;
      } catch (MismatchedDimensionException | TransformException | FactoryException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    } else {
      unit = (Unit<Length>) origCRS.getCoordinateSystem().getAxis(0).getUnit();

    }


    // buffer
    Geometry out = pGeom.buffer(distance.doubleValue(unit));
    Geometry retGeom = out;
    // reproject the geometry to the original projection
    if (!(origCRS instanceof ProjectedCRS)) {
      try {
        retGeom = JTS.transform(out, fromTransform);

      } catch (MismatchedDimensionException | TransformException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    return retGeom;
  }