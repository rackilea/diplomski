@NonNull
@Override
public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    // create a new view
    View v = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.list_item_service, parent, false);
    return new MyViewHolder(v);
    }