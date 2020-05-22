public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

    View view = layoutInflater.inflate(R.layout.async_holder_item, parent, false);
    AsyncLayoutInflater asyncLayoutInflater = new AsyncLayoutInflater(parent.getContext());
    asyncLayoutInflater.inflate(viewType, (ViewGroup) view, new AsyncLayoutInflater.OnInflateFinishedListener() {
        @Override
        public void onInflateFinished(@NonNull View view, int resid, @Nullable ViewGroup parent) {
            parent.addView(view);
        }
    });

    return new ItemViewHolder(view, viewType);
}