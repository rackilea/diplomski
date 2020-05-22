Area area; // The value is set elsewhere in the code    
ArrayList<double[]> areaPoints = new ArrayList<double[]>();
ArrayList<Line2D.Double> areaSegments = new ArrayList<Line2D.Double>();
double[] coords = new double[6];

for (PathIterator pi = area.getPathIterator(null); !pi.isDone(); pi.next()) {
    // The type will be SEG_LINETO, SEG_MOVETO, or SEG_CLOSE
    // Because the Area is composed of straight lines
    int type = pi.currentSegment(coords);
    // We record a double array of {segment type, x coord, y coord}
    double[] pathIteratorCoords = {type, coords[0], coords[1]};
    areaPoints.add(pathIteratorCoords);
}

double[] start = new double[3]; // To record where each polygon starts

for (int i = 0; i < areaPoints.size(); i++) {
    // If we're not on the last point, return a line from this point to the next
    double[] currentElement = areaPoints.get(i);

    // We need a default value in case we've reached the end of the ArrayList
    double[] nextElement = {-1, -1, -1};
    if (i < areaPoints.size() - 1) {
        nextElement = areaPoints.get(i + 1);
    }

    // Make the lines
    if (currentElement[0] == PathIterator.SEG_MOVETO) {
        start = currentElement; // Record where the polygon started to close it later
    } 

    if (nextElement[0] == PathIterator.SEG_LINETO) {
        areaSegments.add(
                new Line2D.Double(
                    currentElement[1], currentElement[2],
                    nextElement[1], nextElement[2]
                )
            );
    } else if (nextElement[0] == PathIterator.SEG_CLOSE) {
        areaSegments.add(
                new Line2D.Double(
                    currentElement[1], currentElement[2],
                    start[1], start[2]
                )
            );
    }
}

// areaSegments now contains all the line segments