FirebaseRecyclerAdapter adapter = new FirebaseRecyclerAdapter<Category, MenuViewHolder>(options) {
    @Override
    public ChatHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Create a new instance of the ViewHolder, in this case we are using a custom
        // layout called R.layout.menu_item for each item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_item, parent, false);

        return new MenuViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(MenuViewHolder holder, int position, Category model) {
        // Bind the Chat object to the ChatHolder
        // ...
    }
};