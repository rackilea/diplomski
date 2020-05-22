public class BitmapDTO {

    private static BitmapDTO instance;

    public static BitmapDTO getInstance() {
        if (instance == null)
            instance = new BitmapDTO();
        return instance;
    }

    private List<Bitmap> bitmaps;

    private BitmapDTO() { }

    public void setBitmaps(List<Bitmap> bitmaps) {
        this.bitmaps = bitmaps;
    }

    public List<Bitmap> getBitmaps() {
        return bitmaps;
    }

}