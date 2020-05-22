public class ExampleAdapter extends RecyclerView.Adapter<ExampleViewHolder> {

    private final LayoutInflater mInflater;
    private final List<ExampleModel> mModels;

    public ExampleAdapter(Context context, List<ExampleModel> models) {
        mInflater = LayoutInflater.from(context);
        mModels = models;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = mInflater.inflate(R.layout.item_example, parent, false);
        return new ExampleViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        final ExampleModel model = mModels.get(position);
        holder.bind(model);
    }

    @Override
    public int getItemCount() {
        return mModels.size();
    }
}