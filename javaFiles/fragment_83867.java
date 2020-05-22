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

        // setup this item's image view based on the current state of the boolean
        if (getItem(position).myItemCheckBoolean) {
            holder.image.setImageResource(R.drawable.image_a);
        } else {
            holder.image.setImageResource(R.drawable.image_b);
        }
        // tag this item's image view with position so it can be retrieved in the onClick
        holder.image.setTag(position);
        // set the OnClickListener for the this item's image view 
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mMyListAdapterListener != null) {
                    // retrieve position from the view's tag, and trigger the listeners onItemCheckClicked method
                    mMyListAdapterListener.onItemCheckClicked((Integer) v.getTag());
                }                    
            }
        });

        // setup this item's background based on the current state of the boolean
        if (getItem(position).myItemCheckBoolean) {
            holder.layout.setBackgroundColor(Color.red);
        } else {
            holder.layout.setBackgroundColor(Color.white);
        }

        return row;
    }

    class ViewHolder {
        ImageView image = null;
        TextView label = null;
        RelativeLayout layout = null;

        // constructor
        ViewHolder(View row) {
            this.image = (ImageView) row.findViewById(R.id.item_image);
            this.label = (TextView) row.findViewById(R.id.item_label);
            this.layout = (RelativeLayout) row.findViewById(R.id.item_layout)
        }
    }
}