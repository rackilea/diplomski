public class FlipperAdapter extends BaseAdapter {

    ArrayList<String> urls;

    public FlipperAdapter(ArrayList<String> urls) {
        this.urls = urls;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return urls.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return urls.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = (LinearLayout) LayoutInflater.inflate(
                    R.layout.viewLayout, parent, false);
        }

        ImageView image = (ImageView) convertView.findViewById(R.id.image);
        imageLoader.displayImage(urls.get(position), image, null);
        return convertView;
    }
}