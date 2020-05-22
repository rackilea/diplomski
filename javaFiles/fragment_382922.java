public class Testing {
    private static List<ImageIcon> images = new ArrayList<>();

    public static void add(ImageIcon im) {
        images.add(im);
    }

    public static List<ImageIcon> get() {
        return Testing.images;
    }
    public static void clear(){
        images.clear();
    }
...