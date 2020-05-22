public class ExampleClickViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView text1, text2;

    ExampleClickViewHolder(View itemView) {
        super(itemView);

        // we do this because we want to check when an item has been clicked:
        itemView.setOnClickListener(this);

        // now, like before, we assign our View variables
        title = (TextView) itemView.findViewById(R.id.text1);
        subtitle = (TextView) itemView.findViewById(R.id.text2);
    }

    @Override
    public void onClick(View v) {
        // The user may not set a click listener for list items, in which case our listener
        // will be null, so we need to check for this
        if (mOnEntryClickListener != null) {
            mOnEntryClickListener.onEntryClick(v, getLayoutPosition());
        }
    }
}