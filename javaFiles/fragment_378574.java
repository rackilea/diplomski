public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {

    private List<Feature> features;

    public DataAdapter(List<Feature> features) {
        this.features = features;
    }

    @Override
    public DataAdapter.DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_data_layout, parent, false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {

        holder.place.setText(features.get(position).getProperties().getPlace());
        holder.alert.setText(features.get(position).getProperties().getAlert());
    }

    @Override
    public int getItemCount() {
        return features.size();
    }

    public static class DataViewHolder extends RecyclerView.ViewHolder {

        private final TextView place;
        private final TextView alert;

        public DataViewHolder(View view) {
            super(view);
            place = (TextView) view.findViewById(R.id.place_text_view);
            alert = (TextView) view.findViewById(R.id.alert_text_view);
        }
    }
}