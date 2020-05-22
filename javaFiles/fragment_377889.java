@Override
    public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.contacts_list_item, viewGroup, false);
        return new ContactViewHolder(itemView,this,contacts);
    }