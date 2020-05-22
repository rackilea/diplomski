@Override
public void onBindViewHolder(ViewHolder holder, int position) {

    String noteT = mListNotes.get(position).getTitle();
    String noteC = mListNotes.get(position).getContent();

    holder.noteTitle.setText(noteT);
    holder.noteDescription.setText(noteC);
    holder.noteCard_settingsButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mDbAdapter = new NotesDbAdapter(mCtx);
            mDbAdapter.open();
            Toast.makeText(mCtx,"The position is:"+holder.getAdapterPosition(),Toast.LENGTH_SHORT).show();
            PopupMenu popup = new PopupMenu(mCtx, view);
            MenuInflater inflater = popup.getMenuInflater();
            inflater.inflate(R.menu.menu_popup, popup.getMenu());
            popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.popup_edit:
                            Toast.makeText(mCtx,"You pressed edit note", Toast.LENGTH_SHORT).show();
                            return true;
                        case R.id.popup_delete:
                            deleteItem(holder.getAdapterPosition());
                            Toast.makeText(mCtx, "Delete note", Toast.LENGTH_SHORT).show();
                            return true;
                    }
                    return false;
                }
            });
            popup.show();
        }
    });
}