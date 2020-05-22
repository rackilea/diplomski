final ArrayList <Set> sets = new ArrayList <> ();

public TrackerAdapter() {
}

public void setItems(ArrayList<Set> sets) {
    this.sets.clear();
    this.sets.addAll(sets)
    notifyDataSetChanged();
}

public View getView(final int position, View convertView, ViewGroup parent) {
    View view = convertView;
    final Set set = sets.get(position);
    final Holder holder;

    if (view == null) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.row_single, parent, false);
        holder = new Holder();
        holder.name = (TextView) view.findViewById(R.id.name);
        view.setTag(holder);
    } else {
        holder = (Holder) view.getTag();
    }

    holder.name.setText(set.getUser().getName());

    return view;
}