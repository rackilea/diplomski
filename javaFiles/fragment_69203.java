public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private ArrayList<String> mDataset;
    private ArrayList<String> mDataset2;
    private ArrayList<String> mDataset3;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView, mTextView2, mTextView3 ;

        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.tv_recycler_item);
            mTextView2 = (TextView) v.findViewById(R.id.tv_recycler_item1);
            mTextView3 = (TextView) v.findViewById(R.id.tv_recycler_item2);
        }
    }

    public RecyclerAdapter(ArrayList<String> dataset, ArrayList<String>dataset2, ArrayList<String>dataset3) {
        mDataset = dataset;
        mDataset2 = datset2;
        mDataset3 = dataset3;

    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.mTextView.setText(mDataset.get(position));
        holder.mTextView1.setText(mDataset2.get(position));
        holder.mTextView.setText(mDataset3.get(position));    
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}