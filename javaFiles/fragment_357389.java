//Cancel btn
holder.rowSuggestAddUser_cancelImage.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        int id = model.get(position).getId();
        deleteItem(position);
        deleteListener.onDelete(id);
    }
});