CoordinateReferenceSystem sourceCRS = CRS.decode("EPSG:4326", true);
    CoordinateReferenceSystem targetCRS = CRS.decode("EPSG:32612");
    MathTransform transformToEpsg4326 = CRS.findMathTransform(targetCRS, sourceCRS);
    double lon = geo_data.getModelTiePoints()[3];// 175784.99999999997 - X
    double lat = geo_data.getModelTiePoints()[4];// 5842215.0   - Y
    GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 32612);
    Geometry pointUpperLeft = geometryFactory.createPoint(new Coordinate(lon, lat));