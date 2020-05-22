public class MyObject {
    private static class MyObjectInitializer {
        int x = default_x_value;
        int y = default_y_value;
        int z = default_z_value;
        MyObjectInitializer(InputStream is) {
            x = in.read();
            if (x == 1) {
                y = in.read();
                if (y == 1) {
                    z = in.read();
                }
            }
        }
    }
    public MyObject(InputStream is) {
        this(new MyObjectInitializer(is));
    }
    private MyObject(MyObjectInitializer init) {
        my_x = init.x;
        my_y = init.y;
        my_z = init.z;
    }
}