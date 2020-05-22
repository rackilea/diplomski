public class ImageAdapter extends BaseAdapter {
        private Context mContext;
        int imageID;

        public ImageAdapter(Context c, int imageResourceID) {
            mContext = c;
            imageID = imageResourceID;
        }

        public int getCount() {
            return 1;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null) {
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8, 8, 8, 8);
            } else {
                imageView = (ImageView) convertView;
            }

            imageView.setImageResource(imageID); //use the image id passed in through the constructor

            return imageView;
        }
    }