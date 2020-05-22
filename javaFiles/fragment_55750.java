import org.opencv.android.Utils;
private void convertToMat(Bitmap bitmap){
    Mat mat = new Mat();
    Bitmap bmp32 = bitmap.copy(Bitmap.Config.ARGB_8888, true);
    Utils.bitmapToMat(bmp32, mat);
}