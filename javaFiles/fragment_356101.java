@Override
public void onTextChanged(CharSequence s, int start, int before, int count) {
       boolean hasContent = (count != 0);
       addBtn.setEnabled(hasContent);
       txtPlaylistName.setHint((hasContent) ? null : "Create new Playlist...");
 }