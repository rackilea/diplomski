public boolean findPath(Game game, Point origin, Point destination, Set<Point> hasVisited,
            int depth) throws Exception {
    if (origin.equals(destination)){
        System.out.println("Return from goal requirements: " + hasVisited);
        return true;
    }

    if (depth != 0) {
        for (Point emptyNeighbor : getEmptyNeighbors(game, origin)) {
            if (!hasVisited.contains(emptyNeighbor)) {
                if (!game.isHiveBrokenAfterPush(origin, emptyNeighbor)) {
                    hasVisited.add(emptyNeighbor);
                    game.push(origin.x, origin.y, emptyNeighbor.x, emptyNeighbor.y);
                    boolean found = findPath(game, emptyNeighbor,
                            destination, actualOrigin, hasVisited, depth - 1);
                    if (found) {
                        return true;
                    }

                    hasVisited.remove(emptyNeighbor);
                    game.push(emptyNeighbor.x, emptyNeighbor.y, origin.x, origin.y);
                }
            }
        }
    }

    System.out.println("Not found");
    return false;
}