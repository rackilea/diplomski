public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    class ViewHolder0 extends RecyclerView.ViewHolder {
        ...
    }

    class ViewHolder2 extends RecyclerView.ViewHolder {
        ...
    }

    @Override
    public int getItemViewType(int position) {
        // Just as an example, return 0 or 2 depending on position
        // Note that unlike in ListView adapters, types don't have to be contiguous
        return position % 2 * 2;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
         switch (viewType) {
             case 0: return new ViewHolder0(...);
             case 2: return new ViewHolder2(...);
             ...
         }
    }
}