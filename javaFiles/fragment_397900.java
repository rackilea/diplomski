public class RewardPointAdapter extends BaseAdapter {
    private LayoutInflater mLayoutInflater;
    private int mMaxRewardPoints;
    private int mCurrentRewardPoints;

    public RewardPointAdapter(Context context, int currentRewardPoints, int maxRewardPoints) {
        mLayoutInflater = LayoutInflater.from(context);
        mMaxRewardPoints = maxRewardPoints;
        mCurrentRewardPoints = currentRewardPoints;
    }

    @Override
    public int getCount() {
        return mMaxRewardPoints;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.list_item_discover, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (position < mCurrentRewardPoints)   {
            viewHolder.stampView.setImageResource(R.drawable.ic_approved_stamp);
        } else  {
            viewHolder.stampView.setImageResource(R.drawable.ic_approved_stamp_disabled);
        }
        return convertView;
    }

    private class ViewHolder {
        public ImageView stampView;

        public ViewHolder(View view)    {
            stampView = (ImageView) view.findViewById(R.id.grid_stamp_image);
        }
    }

}