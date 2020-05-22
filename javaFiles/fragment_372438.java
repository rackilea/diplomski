class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<String> items = new ArrayList<>();

    public void addItem(String name) {
        items.add(name);
        notifyItemInserted(items.size() - 1);
    }

    public void removeItem(int position) {
        items.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.grid_item_button, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setButtonName(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Button button;

        public ViewHolder(View itemView) {
            super(itemView);
            button = (Button) itemView.findViewById(R.id.grid_button);
            button.setOnClickListener(this);
        }


        public void setButtonName(String buttonName) {
            button.setText(buttonName);
        }

        @Override
        public void onClick(View v) {
            removeItem(getAdapterPosition());
        }
    }
}