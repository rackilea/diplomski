public class CityViewHolder extends RecyclerView.ViewHolder {

    private FrameLayout yourRootView;

    public ViewHolder(View v) {
        super(v);

        yourRootView = (FrameLayout) v.findViewById(R.id.item_root_view);
    }
}