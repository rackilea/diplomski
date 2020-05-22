public static MyObject makeMyObject(InputStream is) {
    int x = default_x_value;
    int y = default_y_value;
    int z = default_z_value;
    x = in.read();
    if (x == 1) {
        y = in.read();
        if (y == 1) {
            z = in.read();
        }
    }
    return new MyObject(x, y, z);
}