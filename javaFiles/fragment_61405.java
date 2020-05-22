public class GridGallery extends Activity
{
    ArrayList<String>list;    
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_gallery);
        DataModel dbModel = new DataModel(this);
        list = dbModel.selectAll();

        GridView sdcardImages = (GridView) findViewById(R.id.sdcard);
        sdcardImages.setAdapter(new ImageAdapter(this));    
    }    

     /**
     * Adapter for our image files.
     */
    private class ImageAdapter extends BaseAdapter {

        private final Context context;     
        public ImageAdapter(Context localContext) {
            context = localContext;
        }

        public int getCount() 
        {
            return list.size();
        }
        public Object getItem(int position) 
        {
            return position;
        }
        public long getItemId(int position) 
        {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) 
        {
            ImageView picturesView;
            if (convertView == null) {
                picturesView = new ImageView(context);    
                 if(list.get(position).contains(".jpg"))
                {
                     bitmap = BitmapFactory.decodeFile(list.get(position)); //Creation of Thumbnail of image
                }
                else if(list.get(position).contains(".mp4"))
                {
                    bitmap = ThumbnailUtils.createVideoThumbnail(list.get(position), 0); //Creation of Thumbnail of video
                }
                picturesView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                picturesView.setPadding(8, 8, 8, 8);
                picturesView.setLayoutParams(new GridView.LayoutParams(100, 100));
            }
            else 
            {
                picturesView = (ImageView)convertView;
            }
            return picturesView;
        }
    }

}