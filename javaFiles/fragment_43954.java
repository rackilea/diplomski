public class CustomAdapter extends BaseAdapter {

        Context context;
       List<RowItem> rowItems;

       CustomAdapter(Context context, List<RowItem> rowItems) {
           this.context = context;
           this.rowItems = rowItems;
       }

       @Override
       public int getCount() {
           return rowItems.size();
       }

       @Override
       public Object getItem(int position) {
           return rowItems.get(position);
       }

       @Override
       public long getItemId(int position) {
           return rowItems.indexOf(getItem(position));
       }

       /* private view holder class */
       private class ViewHolder {
           ImageView profile_pic;
           TextView pic_name;
       }

       @Override
       public View getView(int position, View convertView, ViewGroup parent) {

           ViewHolder holder = null;

           View mView;

           LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

           if (convertView == null) {
               convertView = mInflater.inflate(R.layout.list_item, null);
               holder = new ViewHolder();

               holder.pic_name = (TextView) convertView.findViewById(R.id.pic_name);
               holder.profile_pic = (ImageView) convertView.findViewById(R.id.profile_pic);

               convertView.setTag(holder);


           } else {
               holder = (ViewHolder) convertView.getTag();
           }

               RowItem row_pos = rowItems.get(position);

               holder.profile_pic.setImageResource(row_pos.getProfile_pic_id());
               holder.pic_name.setText(row_pos.getPic_name());

           return convertView;
       }
   }