HashMap<Point, Point> mapPointToPoint = new HashMap<>();

// (0,0) maps to shadow grid (1,2)
mapPointToPoint.put(new Point(0,0), new Point(1,2));
mapPointToPoint.put(new Point(0,1), new Point(2,1));
// ... more mappings for all the cells

// to get 
Point pointInPlayableGrid = new Point(0,0);
Point pointInShadowGrid = mapPointToPoint.get(pointInPlayableGrid);
// pointInShadowGrid == (1,2) since that's what it was mapped to