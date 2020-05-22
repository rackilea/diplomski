private IMainActivity mInterface;

@Override
public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
    super.onAttachedToRecyclerView(recyclerView);
    //instantiate interface when view attach to the recycler view
    mInterface = (IMainActivity) mContext;
}

holder.cardView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mInterface.navigateFragment();
        }
    });