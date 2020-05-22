private class LikeHolder extends RecyclerView.ViewHolder
    implements View.OnClickListener {

    private boolean mLiked = false;

    public LikeHolder(LayoutInflater inflater, ViewGroup parent) {
        super(inflater.inflate(R.layout.your_holder_layout, parent, false));

        itemView.setOnClickListener(this);
        ...
    }


    @Override
    public void onClick(View view) {
     if (!mLiked){
            mLiked = true;
    }
}