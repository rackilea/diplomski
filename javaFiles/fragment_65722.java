public static class NoteViewHolder extends RecyclerView.ViewHolder
{
    TextView noteName;
    NoteListCommandListener noteListCommandListener;
    public NoteViewHolder(View itemView) {

        super(itemView);
        noteName = (TextView)itemView.findViewById(R.id.note_name);
        itemView.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                contextMenu.setHeaderTitle("Select The Action");
                contextMenu.add(0,42,0,"Delete Note").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        noteListCommandListener.remove(n);
                        return true;
                    }
                });


            }
        });


        }


}