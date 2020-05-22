public class StackOverflowActivity extends Activity{

    private int screen_width;
    private int screen_height;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // in main.xml use an ImageView with android:id="@+id/img"
        ImageView view = (ImageView)findViewById(R.id.img);

        // in your drawables folder, put an image named circle.png
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.circle);

        Display display = getWindowManager().getDefaultDisplay(); 
        screen_width = display.getWidth();
        screen_height = display.getHeight();

        Bitmap scale = resizeBitmap(bmp, 100);

        view.setImageBitmap(scale);

    }

    public Bitmap resizeBitmap(Bitmap bitmap, int screen_percentage)
    {
            ////////////// IMPORTANT ////////////////////
            // Use '/ 100.0f' otherwise your percentage will be 0..
            // this will later on, cause the newWidth & newHeight to be 0 as well
            // which causes the app to crash
        float percentage = screen_percentage / 100.0f;

        float scale = screen_width / 100 * percentage;
        if(screen_width < screen_height)
        {
            scale = screen_height / 100 * percentage;
        }

        int newWidth = (int) (bitmap.getWidth() * scale);
        int newHeight = (int) (bitmap.getHeight() * scale);

            if(newWidth <= 0 || newHeight <= 0)
            { // Extra check, for invalid width/height
                Log.e("test", "invalid dimension ("+newWidth+"x"+newHeight+")");
                return bitmap;
            }
        return Bitmap.createScaledBitmap (bitmap, newWidth, newHeight, true);
    }
}