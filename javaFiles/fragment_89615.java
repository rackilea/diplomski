public class BitmapContainer {

    public static class Bitmap {
        private final long id;
        public Bitmap(long id) { this.id = id; }
        public long getId() { return id; }
        public void draw() { };
    }

    WeakHashMap<Bitmap, WeakReference<Bitmap>> myBitmaps
        = new WeakHashMap<Bitmap, WeakReference<Bitmap>>();

    public void registerBitMap(Bitmap bm) {

        if ( bm == null ) throw new NullPointerException();

        WeakReference<Bitmap> wr = new WeakReference<Bitmap>(bm);
        myBitmaps.put(bm, wr);

    }

    /** Method returns null if bitmap not available */
    public Bitmap getBitMap(long id) {

        for ( Bitmap item : myBitmaps.keySet() ) {
            if ( item != null) {
                if ( item.getId() == id ) {
                    return item;
                }
            }
        }

        return null;

    }

}