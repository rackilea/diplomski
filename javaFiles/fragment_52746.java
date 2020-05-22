@Override
protected void onBindViewHolder(@NonNull Bkhomeholder holder, int position, @NonNull Bookdeets model) {

    ....

    holder.title.setText(model.getBookname());

    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            // Do your operation here
        }
    });

}