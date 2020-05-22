public void travel(int x, int y, String path) {
    if (x == 0 && y == 0) {
        System.out.println(path);
    } else if (x > 0 && y > 0) {
        travel(x-1, y, path + ' E');
        travel(x, y-1, path + ' N');
        travel(x-1, y-1, path + ' NE');
    } else if (x > 0 && y == 0) {
        travel(x-1, y, path + ' E');
    } else if (y > 0 && x == 0) {
        travel(x, y-1, path + ' N');
    }
}