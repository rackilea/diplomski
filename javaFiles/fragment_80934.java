public class MainActivity extends Activity {

    private ListView listView;
    private CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);
        listView = findViewById(android.R.id.list);
    }

    private class ImageDownloader extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
              return downloadBitmap(params[0]);
            } catch (ClientProtocolException e) {
               return null;
            } catch (Exception e) {
               return null;
            }
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            adapter = new CustomAdapter(bitmap);
            listView.setAdapter(adapter);

            super.onPostExecute(bitmap);
        }
    }

    private class CustomAdapter extends BaseAdapter {

        private Bitmap bitmap;
        private LayoutInflater inflater = null;

        class ViewHolder {
            ImageView image;
        }

        public CustomAdapter(Bitmap bitmap) {
            this.bitmap = bitmap;
            inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup parent) {
            final ViewHolder holder;
            if(convertView == null) {
                convertView = inflater.inflate(R.layout.list_item, parent, false);

                holder.image = convertView.findViewById(R.id.imageView);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.image.setImageBitmap();

            return convertView;
        }
    }
}