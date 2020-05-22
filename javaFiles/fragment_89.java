public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
   DisplayMetrics metrics=new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(metrics);
    Gallery gallery = (Gallery) findViewById(R.id.gallery);
    Integer[] mImageIds = {
            R.drawable.ic_launcher,
            R.drawable.ic_menu_template,
            R.drawable.th,
            R.drawable.wt,
            R.drawable.cur,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher
    };     

    gallery.setAdapter(new ImageAdapter(this, mImageIds));
    gallery.setSelection((int)(Integer.MAX_VALUE / 2) - (Integer.MAX_VALUE / 2)%       mImageIds.length);

    gallery.setOnItemClickListener(new OnItemClickListener() {
        public void onItemClick(AdapterView parent, View v, int position, long id) {
            EditText editText2=(EditText) findViewById(R.id.editText2);
            editText2.setText(""+position);
        }
    });
}
public class ImageAdapter extends BaseAdapter {
    int mGalleryItemBackground;
    private Context mContext;

    private Integer[] mImageIds = null;

    public ImageAdapter(Context c, Integer[] imageIds) {
        mContext = c;
        mImageIds = imageIds;
        TypedArray attr = mContext.obtainStyledAttributes(R.styleable.Frames);
        mGalleryItemBackground = attr.getResourceId(
                R.styleable.Frames_android_galleryItemBackground, 0);
        attr.recycle();
    }

    public int getCount() {
        return (mImageIds != null) ? mImageIds.length : 0;
    }