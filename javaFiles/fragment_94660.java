final double MAX_SEARCH_DISTANCE = Math.max(index.getBounds().getWidth(), index.getBounds().getHeight());
    double searchDist = 0.01;

    while (searchDist < MAX_SEARCH_DISTANCE) {
        // start point (user input)
        Coordinate coordinate = p.getCoordinate();

        ReferencedEnvelope search = new ReferencedEnvelope(new Envelope(coordinate),
                index.getSchema().getCoordinateReferenceSystem());

        search.expandBy(searchDist);
        BBOX bbox = ff.bbox(ff.property(index.getSchema().getGeometryDescriptor().getName()), (BoundingBox) search);
        SimpleFeatureCollection candidates = index.subCollection(bbox);

        double minDist = Double.POSITIVE_INFINITY; // can't use
                                                    // MAX_Search_dist here
                                                    // as it is degrees and
                                                    // dists are meters
        Coordinate minDistPoint = null;
        double dist = 0;
        Point dest = null;
        SimpleFeatureIterator itr = candidates.features();
        CoordinateReferenceSystem crs = DefaultGeographicCRS.WGS84;
        try {
            SimpleFeature feature = null;
            while (itr.hasNext()) {
                feature = itr.next();

                // destination point
                dest = (Point) feature.getDefaultGeometry();
                GeodeticCalculator gc = new GeodeticCalculator(crs);
                gc.setStartingPosition(JTS.toDirectPosition(p.getCoordinate(), crs));
                gc.setDestinationPosition(JTS.toDirectPosition(dest.getCoordinate(), crs));
                // Calculate distance between points
                dist = gc.getOrthodromicDistance();
                // System.out.println(feature.getID()+": "+dist);
                if (dist < minDist) {
                    minDist = dist;
                    minDistPoint = dest.getCoordinate();
                    lastMatched = feature;
                }
            }

        } finally {
            itr.close();
        }
        Point ret = null;

        if (minDistPoint == null) {
            searchDist *= 2.0;
            System.out.println("repeat search");
        } else {
            ret = gf.createPoint(minDistPoint);
            return ret;
        }
    }
    return gf.createPoint(new Coordinate());
}