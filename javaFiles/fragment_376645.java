private void iteratePaths(Location currentLoc, List<Direction> currentPath, List<List<Direction>> allPaths, int pathLength) {
    if (currentPath.size() >= pathLength) {
        allPaths.add(new ArrayList<Direction>(currentPath));
        return;
    }
    for (Direction d : currentLoc.getPosDirections()) {
        currentPath.add(d);
        Location newLoc = currentLoc.walk(d);

        iteratePaths(newLoc, currentPath, allPaths, pathLength);

        currentPath.remove(currentPath.size() - 1);
    }
}

public void List<List<Direction>> getAllPaths(Location loc, int length) {
    List<List<Direction>> allPaths = new ArrayList<List<Direction>>();
    List<Direction> currentPath = new ArrayList<Direction>();
    iteratePaths(loc, currentPath, allPaths, length);
    return allPaths;
}