private class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_1 = 1;
    private static final int TYPE_2 = 2;
    private static final int TYPE_3 = 3;
    // more types...

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_1:
                break;
            case TYPE_2:
                break;
            case TYPE_3:
                break;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case TYPE_1:
                break;
            case TYPE_2:
                break;
            case TYPE_3:
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 1) {
            return TYPE_1;
        } else if(position == 2) {
            return TYPE_2;
        } else 
            return TYPE_3
    }

    @Override
    public int getItemCount() {
        return 10;
    }
}