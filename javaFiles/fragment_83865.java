public class MyListAdapter extends ArrayAdapter<MyItem> {

    // interface for handling item child view events
    public interface MyListAdapterListener {
        void onItemCheckClicked(int index);
        void onItemLabelLongClicked(int index);        
    }

    private MyListAdapterListener mMyListAdapterListener;
    int layoutResID;

    // Constructor
    public MyListAdapter(Context context, int resource, List<MyItem> myItems) {
        super(context, resource, myItems);
        layoutResID = resource;
    }

    public void setMyListAdapterListener(MyListAdapterListener listener) {
        this.mMyListAdapterListener = listener;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // setup the row
        View row;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            row = inflater.inflate(layoutResID, null);
        } else {
            row = convertView;
        }

        // setup the ViewHolder for this item
        ViewHolder holder = (ViewHolder) row.getTag();
        if (holder == null) {
            holder = new ViewHolder(row);
            row.setTag(holder);
        }

        // setup this item's label view
        holder.label.setText(getItem(position).label);
        // tag this item's label view with position so it can be retrieved in the onLongClick
        holder.label.setTag(position);
        // set the OnLongClickListener for the this item's label view 
        holder.label.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mActivityListListener != null) {
                // retrieve position from the view's tag, and trigger the listeners onItemLabelLongClicked method
                    mActivityListListener.onItemLabelLongClicked((Integer)v.getTag());
                }
                return false;
            }
        });

        // setup this item's checkbox view
        holder.checkbox.setChecked(getItem(position).myItemCheckBoolean);
        // tag this item's checkbox view with position so it can be retrieved in the onClick
        holder.checkbox.setTag(position);
        // set the OnClickListener for the this item's checkbox view 
        holder.checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mMyListAdapterListener != null) {
                    // retrieve position from the view's tag, and trigger the listeners onItemCheckClicked method
                    mMyListAdapterListener.onItemCheckClicked((Integer) v.getTag());
                }                    
            }
        });

        return row;
    }

    class ViewHolder {
        CheckBox checkbox = null;
        TextView label = null;

        ViewHolder(View row) {
            this.checkbox = (CheckBox) row.findViewById(R.id.check_box);
            this.label = (TextView) row.findViewById(R.id.item_label);
        }
    }
}