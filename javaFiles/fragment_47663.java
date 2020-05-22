class Location {
    int x;
    int y;

    List<Location> adjacent() {
        // TODO return list of locations reachable in a single step
    }
}

List<Location> findShortestPath(Location start, Location destination) {
    Location[][] previous = new Location[8][8];

    Deque<Location> queue = new ArrayDeque<>();
    queue.add(start);
    do {
        Location loc = queue.poll();
        for (Location n : loc.neighbors()) {
            if (previous[n.x][n.y] == null) {
                previous[n.x][n.y] = loc;
                queue.add(n);

                if (n.x == destination.x && n.y == destination.y) {
                    // we've found a way, let's reconstruct the list of steps
                    List<Location> path = new ArrayList<>();
                    for (Location l = n; l != start; l = previous[l.x][l.y]) {
                        path.add(l);
                    }
                    path.reverse();
                    return path;
                }
            }
        }
    } while (!queue.isEmpty());
    return null; // no path exists
}