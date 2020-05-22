FirestoreRecyclerAdapter<Spots, SpotViewHolder> adapter = new FirestoreRecyclerAdapter<Spots, SpotViewHolder>(options) {
    @Override
    protected void onBindViewHolder(@NonNull SpotViewHolder spotViewHolder, int i, @NonNull Spots spots) {
    //...
    }

    @NonNull
    @Override
    public SpotViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    //...
    }


    // Add this
    @Override
    public void onDataChanged() {
    // do your thing
    if(getItemCount() == 0)
    Toast.makeText(getContext(), "Empty", Toast.LENGTH_SHORT).show();
    }
};