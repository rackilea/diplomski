@Override
public void onBindViewHolder(final MyViewHolder holder, int position) {
    ExRow expense = expenseList.get(holder.getAdapterPosition());
    holder.title.setText(expense.getTitle());
    holder.amount.setText(expense.getAmount());
    mRemoveButton.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view) {
            // Remove the item on remove/button click
            int adapterPosition = holder.getAdapterPosition();
            expenseList.remove(adapterPosition);
            notifyItemRemoved(adapterPosition);
            notifyDatasetChanged();
        }
    });
}