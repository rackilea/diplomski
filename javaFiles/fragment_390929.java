int current = 1;
// Start in the corner
int x = 0, y = 0, dx = 1, dy = 0;
while (current <= N*N) {
    // Go in a straight line
    spiral[x][y] = current++;
    int nx = x + dx, ny = y + dy;
    // When you hit the edge...
    if (nx < 0 || nx == N || ny < 0 || ny == N || spiral[nx][ny] != 0) {
        // ...turn right
        int t = dy;
        dy = dx;
        dx = -t;
    }
    x += dx;
    y += dy;
}