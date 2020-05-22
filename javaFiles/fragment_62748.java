private void computeAllPaths(Point current, ArrayList<Point> currentFullPath) {

    if (currentFullPath.isEmpty()) {
        currentFullPath.add(current);
    }

    for (Point coord : neighbouringCoords.get(current)) {
        if (!(currentFullPath.contains(coord))) {
            ArrayList<Point> newList = new ArrayList<Point>(currentFullPath);
            newList.add(coord);
            if (!(paths.contains(newList))) {
                paths.add(newList);
                //start over again with same coord
                computeAllPaths(currentFullPath.get(0), new ArrayList<Point>()); 
            } else {
                //try to add another coord
                computeAllPaths(coord, newList); 
            }
        }
    }
}