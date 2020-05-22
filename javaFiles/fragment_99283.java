public class Face extends Activity {
 private Bitmap bitmap;
 private int f = Crop.k;
 private ImageView tv;
 Mat m;
 private static final String    TAG                 = "OCVSample::Activity";

  private BaseLoaderCallback mLoaderCallback = new BaseLoaderCallback(this) {
@Override
public void onManagerConnected(int status) {
    switch (status) {
        case LoaderCallbackInterface.SUCCESS:
        {
            Log.i(TAG, "OpenCV loaded successfully");
            m=new Mat();
        } break;
        default:
        {
            super.onManagerConnected(status);
        } break;
    }
}
};