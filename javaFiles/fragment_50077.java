public class TheAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<TheJSON> json_collection;
    private ArrayList<String> the_strings;
    private ArrayList<int> the_view_types;

    public TheAdapter(ArrayList<TheJSON> json_collection) {
        this.json_collection = json_collection;

        for (int i = 0; i < json_collection; i++) {
            the_string.add(json_collection.get(i).foo1);
            the_view_types.add(1);
            for (int j = 0; j < json_collection.get(i).foo2.size(); j++) {
                the_string.add(json_collection.get(i).foo2.get(j));
                the_view_types.add(2);
            }
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 1:
                return new Foo1ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.foo1_layout, parent, false));

            case 2:
                return new Foo2ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.foo2_layout, parent, false));

            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (the_view_types.get(position)) {
            case 1:
                Foo1ViewHolder foo1ViewHolder = (Foo1ViewHolder) holder;
                foo1ViewHolder.setText(the_strings.get(position));
                break;

            case 2:
                Foo2ViewHolder foo2ViewHolder = (Foo2ViewHolder) holder;
                foo2ViewHolder.setText(the_strings.get(position));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return the_strings.size();
    }

    @Override
    public int getItemViewType(int position) {
        return the_view_types.get(position);
    }

    public class Foo1ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvFoo1Value;

        public Foo1ViewHolder(View itemView) {
            super(itemView);
            tvFoo1Value = (TextView) itemView.findViewById(R.id.tvFoo1Value);
        }

        public setText(String text) {
            tvFoo1Value.setText(text);
        }
    }

    public class Foo2ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvFoo2Value;

        public Foo2ViewHolder(View itemView) {
            super(itemView);
            tvFoo2Value = (TextView) itemView.findViewById(R.id.tvFoo2Value);
        }

        public setText(String text) {
            tvFoo2Value.setText(text);
        }
    }
}