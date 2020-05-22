public class PendingAdapter extends BaseAdapter {

    private List<Map<String, Object>> mPendingItemList;

    public PendingAdapter() {
        mPendingItemList = DataModel.getInstance().getPendingItemList();
    }

    @Override
    public int getCount() {
        return mPendingItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return mPendingItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (null == convertView) {

            convertView = LayoutInflater.from(getActivity()).inflate(
                    R.layout.pending_item, null);
            holder = new ViewHolder();

            holder.tv_title = (TextView) convertView
                    .findViewById(R.id.pi_tv_title);
            holder.tv_content = (TextView) convertView
                    .findViewById(R.id.pi_tv_content);
            holder.tv_counter = (TextView) convertView
                    .findViewById(R.id.pi_tv_counter);
            holder.tv_ongoing = (TextView) convertView
                    .findViewById(R.id.pi_tv_ongoing);
            holder.tv_type = (TextView) convertView
                    .findViewById(R.id.pi_tv_type);
            holder.tv_date = (TextView) convertView
                    .findViewById(R.id.pi_tv_date);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        @SuppressWarnings("unchecked")
        HashMap<String, String> itemDataHashMap = (HashMap<String, String>) getItem(position);

        holder.tv_title.setText(itemDataHashMap.get("planet"));
        holder.tv_content.setText(itemDataHashMap.get("content"));
        holder.tv_counter.setText(itemDataHashMap.get("counter"));
        holder. tv_type.setText(itemDataHashMap.get("type"));
        holder.tv_ongoing.setText(itemDataHashMap.get("ongoing"));
        holder.tv_date.setText(itemDataHashMap.get("date"));

        convertView.setTag(holder);
        return convertView;
    }

    static class ViewHolder {
        TextView tv_title;
        TextView tv_content;
        TextView tv_counter;
        TextView tv_ongoing;
        TextView tv_type;
        TextView tv_date;
    }
}