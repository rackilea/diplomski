public class CustomAdapter extends ArrayAdapter<Tweet> {

    private Context mContext;
    private int layoutId;
    private ArrayList<Tweet> dataList;

    public CustomAdapter(Context context, int resourceId,
            ArrayList<Tweet> objects) {
        super(context, resourceId, objects);
        // TODO Auto-generated constructor stub
        mContext = context;
        layoutId = resourceId;
        dataList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        ViewHolder viewHolder;
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layoutId, null);
            viewHolder = new ViewHolder();
            viewHolder.listItemTxtView = (TextView) convertView.findViewById(R.id.listItemTxtView);
            viewHolder.listItemImgView = (ImageView) convertView.findViewById(R.id.listItemImgView);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.listItemTxtView.setText(dataList.get(position).toString());
        //place picasso jar into libs folder of your project and use it for download and  set images like this
        Picasso.with(context).load("url of image you want to load").into(viewHolder.listItemImgView);
        return convertView;
    }

    private class ViewHolder {
        TextView listItemTxtView;
        ImageView listItemImgView;
    }
}