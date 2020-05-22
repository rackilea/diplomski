@Override
    public ViewDraftsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.completed_and_drafts_list_item, parent, false);
        return new ViewDraftsViewHolder(view);
    }