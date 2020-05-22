public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
    if(position >= mCards.size()) {
        return;
    }
    holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(itemView.getContext(), "Test", Toast.LENGTH_SHORT).show();
            }
        });
    holder.word.setText(mCards.get(position).getWord());
 }