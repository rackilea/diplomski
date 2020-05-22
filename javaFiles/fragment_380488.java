public class MyCarProfileRecyclerViewAdapter extends RecyclerView.Adapter<MyCarProfileRecyclerViewAdapter.ViewHolder> {

private final List<CarProfile> mValues;
private final OnListFragmentInteractionListener mListener;

public MyCarProfileRecyclerViewAdapter(List<CarProfile> items, OnListFragmentInteractionListener listener) {
    mValues = items;
    mListener = listener;
}

@Override
public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.fragment_carprofile, parent, false);
    return new ViewHolder(view);
}

@Override
public void onBindViewHolder(final ViewHolder holder, int position) {
    holder.mItem = mValues.get(position);
    holder.mPlateNumberTextView.setText(mValues.get(position).getPlateNumber());
    holder.mBrandTextView.setText(mValues.get(position).getBrand());
    holder.mModelTextView.setText(mValues.get(position).getModel());
    holder.mColorTextView.setText(mValues.get(position).getColor());
}

@Override
public int getItemCount() {
    return mValues.size();
}

public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public final TextView mPlateNumberTextView;
    public final TextView mBrandTextView;
    public final TextView mModelTextView;
    public final TextView mColorTextView;
    public CarProfile mItem;

    public ViewHolder(View view) {
        super(view);

        view.setClickable(true); // This is important
        view.setOnClickListener(this);

        mPlateNumberTextView = (TextView) view.findViewById(R.id.plateNumberTextView);
        mBrandTextView = (TextView) view.findViewById(R.id.brandTextView);
        mModelTextView = (TextView) view.findViewById(R.id.modelTextView);
        mColorTextView = (TextView) view.findViewById(R.id.colorTextView);
    }

    public void onClick(View view) {
       if (null != mListener) {
            mListener.onListFragmentInteraction(mValues.get(getAdapterPosition()));
       }
    }

    @Override
    public String toString() {
        return super.toString() + " '" + mPlateNumberTextView.getText() + "'";
    }
   }