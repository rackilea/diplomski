public static boolean noErrors(SurfacePolygonX p1, SurfacePolygonX p2, List<LatLon> list) {
    boolean allPointsInSamePolygon = true;

    //for each latlon jl in locations, cast jl and jl2 as points    
    for (int j = 0; j < list.size(); j++) {
        LatLon jl = list.get(j);
        LatLon jl2 = list.get((j == list.size() - 1) ? 0 : j + 1);
        Point2D pt = new Point2D(jl.longitude.degrees, jl.latitude.degrees);
        Point2D pt2 = new Point2D(jl2.longitude.degrees, jl2.latitude.degrees);

        List<LatLon> corners = p1.getCorners();

        boolean bothPointsInSameSegment = false;

        //for each latlon k selectedShape cast k and k+1 as 2lineseg
        for (int k = 0; k < corners.size(); k++) {
            LatLon kl = corners.get(k);
            LatLon kl2 = corners.get((k == corners.size() - 1) ? 0 : k + 1);

            LineSegment2D segment = new LineSegment2D(kl.longitude.degrees, kl.latitude.degrees, kl2.longitude.degrees, kl2.latitude.degrees);

            boolean segContainsP1 = segment.contains(pt);
            boolean segContainsP2 = segment.contains(pt2);

            System.out.println("selectedShape: segment "+k+" contains p"+j+":("+segContainsP1+") and p"+(j+1)+":("+segContainsP2+")");

            //check if each line contains the points.
            if (segContainsP1 && segContainsP2)
            {
                bothPointsInSameSegment = true;
            }

        }

        corners = p2.getCorners();
        //for each latlon k tempShape cast k and k+1 as 2lineseg
        for (int k = 0; k < corners.size(); k++) {
            LatLon kl = corners.get(k);
            LatLon kl2 = corners.get((k == corners.size() - 1) ? 0 : k + 1);

            LineSegment2D segment = new LineSegment2D(kl.longitude.degrees, kl.latitude.degrees, kl2.longitude.degrees, kl2.latitude.degrees);


            boolean segContainsP1 = segment.contains(pt);
            boolean segContainsP2 = segment.contains(pt2);

            System.out.println("intersectingShape: segment "+k+" contains p"+j+":("+segContainsP1+") and p"+(j+1)+":("+segContainsP2+")");

            //check if each line contains the points.
            if (segContainsP1 && segContainsP2)
            {
                bothPointsInSameSegment = true;
            }

        }

        if (!bothPointsInSameSegment) allPointsInSamePolygon = false;

    }

    //if both points are not in the same line, then theres a conflict
    return allPointsInSamePolygon;
}