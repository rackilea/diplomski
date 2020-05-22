private void computeAllPaths(Point current, ArrayList<Point> currentFullPath) {

    if (currentFullPath.isEmpty()) {
        currentFullPath.add(current);
    }

    for (Point coord : neighbouringCoords.get(current)) {
        if (!(currentFullPath.contains(coord))) {
            ArrayList<Point> newList = new ArrayList<Point>(currentFullPath);
            newList.add(coord);
            paths.add(newList);                           
            computeAllPaths(coord, new ArrayList<Point>(newList));            
        }
    }
}