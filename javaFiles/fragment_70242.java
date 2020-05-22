@Override
public void onBindViewHolder(MainActivity.DealsHolder holder, int position, DealsResponse model) {
    // ...
    holder.itemView.setOnClickListener(v -> {
        DocumentSnapshot snapshot = getSnapshots().getSnapshot(holder.getAdapterPosition());
        snapshot.getId();
        // ...
    }); 
}