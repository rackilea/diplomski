//Cancel btn
holder.rowSuggestAddUser_cancelImage.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        deleteItem(position);
        deleteListener.onDelete(model.get(position).getId());
    }
});