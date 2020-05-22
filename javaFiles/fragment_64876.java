char [][] grid;
Deque<Point> queue = new ArrayDeque<>();
HashSet<Point> visited = new HashSet<>();
int kx; // x coordinate of k
int ky; // y coordinate of k
Point start = new Point(kx, ky);
queue.add(start);

int [] dx = {0, 0, 1, -1, -1, 1, 1, -1};
int [] dy = {1, -1, 0, 0, -1, 1, -1, 1};
while (!queue.isEmpty()) {
    Point p = queue.poll();
    if (visited.contains(p)) {
        continue;
    }
    visited.add(p);
    for (int i = 0; i < dx.length; i++) {
        int nx = (int)p.getX()+dx[i];
        int ny = (int)p.getY()+dy[i];
        if (validCoordinates(nx, ny) && grid[nx][ny] == ' ')) {
            queue.add(new Point(nx, ny));
        }
    }
}

boolean allReachable = true;
outer: for (int i = 0; i < grid.length; i++) {
    for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == ' ' && !visited.contains(new Point(i, j))) {
            allReachable = false;
            break outer;
        }
    }
}

System.out.println(allReachable ? "All white spaces are reachable" : "Not all white spaces are reachable");