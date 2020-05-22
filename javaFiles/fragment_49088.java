List<Point> points = ...;
// first plot the points
for (Point point: points) {
    array[point.x][point.y] = 'X';
}
// now plot the regression line
for (int x = 0; x < 40; x++) {
    int y = Math.round(yMean + slope * (x - xMean));
    array[x][y] = array[x][y] == 'X' ? '*' : '-';
}