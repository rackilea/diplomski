private static void searchNeighboringPixels(int x, int y, int[][] arr) {
    Stack<Point> points = new Stack<>();
    points.push(new Point(x,y));
    while (!points.isEmpty()) {
        Point p = points.pop();
        x = p.getX();
        y = p.getY();
        arr[y][x] = 2;
        if (x+1 < arr[y].length && arr[y][x+1] == 1) {
            points.push(new Point(x+1,y);
            //...do other things
        }
        if (x-1 > 0 && arr[y][x-1] == 1) {
            points.push(new Point(x-1,y);
            //...do other things
        }
        if (y+1 < arr.length && arr[y+1][x] == 1) {
            points.push(new Point(x,y+1);
            //...do other things
        }
        if (y-1 > 0 && arr[y-1][x] == 1) {
            points.push(new Point(x,y-1);
            //...do other things
        }
    }
}