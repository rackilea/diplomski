public class BitmapTextureSource extends EmptyBitmapTextureAtlasSource {

private Bitmap mBitmap;

public BitmapTextureSource(Bitmap bitmap) {
    super(bitmap.getWidth(), bitmap.getHeight());
    mBitmap = bitmap;       
}

@Override
public Bitmap onLoadBitmap(Config pBitmapConfig) {
    return mBitmap.copy(pBitmapConfig, true);       
}