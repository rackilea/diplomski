public class PlaceListRecyclerViewAdapter extends RecyclerView.Adapter<PlaceListRecyclerViewAdapter.StoreObjectHolder>{
    private static String LOG_TAG = "StoreRecyclerViewAdapter: ";
    private ArrayList <Store> mDataSet;
    private static MyClickListener myClickListener;



    public static class StoreObjectHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        protected ImageView StoreImage;
        protected TextView StoreName;
        protected TextView StorePrice;
        public StoreObjectHolder(View view){
            super(view);
            StoreImage = (ImageView) view.findViewById(R.id.place_picture);
            StoreName = (TextView) view.findViewById(R.id.place_name);
            Log.i(LOG_TAG, "Adding Listener");
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getAdapterPosition(), v);
            Log.d(LOG_TAG, "Listener has been called, returning control to calling class");
        }
    }

    public void setOnItemClickListener (MyClickListener myClickListener){
        PlaceListRecyclerViewAdapter.myClickListener = myClickListener;
    }

    public PlaceListRecyclerViewAdapter(ArrayList<Store> myDataSet){
        mDataSet = myDataSet;
    }

    @Override
    public StoreObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.place_item, parent, false);
        StoreObjectHolder StoreObjectHolder = new StoreObjectHolder(view);
        //return new StoreObjectHolder(view);
        return StoreObjectHolder;
    }

    @Override
    public void onBindViewHolder(StoreObjectHolder holder, int position) {
        // TODO: Replace with proper, complete logic here
        holder.StoreName.setText(mDataSet.get(position).getName());
    }

    public void addItems(ArrayList<Store> stores, int index){
        int cursize = mDataSet.size();
        mDataSet.addAll(index, stores);
        if (getItemCount() != 0) {
            notifyItemRangeInserted(index, (mDataSet.size() - cursize));
        } else {
            notifyDataSetChanged();
        }
    }

    public void deleteItem (int index){
        mDataSet.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public interface MyClickListener {
        void onItemClick(int position, View v);
    }
}