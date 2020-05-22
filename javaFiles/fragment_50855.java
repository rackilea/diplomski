public class ImageLoader2 extends ImageLoader {

    private volatile static ImageLoader instance;

    /** Returns singleton class instance */
    public static ImageLoader getInstance() {
        if (instance == null) {
            synchronized (ImageLoader2.class) {
                if (instance == null) {
                    instance = new ImageLoader2();
                }
            }
        }
        return instance;
    }
}