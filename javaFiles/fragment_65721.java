@Override
public void onBindViewHolder(NoteViewHolder personViewHolder, int i) {

    String name = notes.get(i).name;
    personViewHolder.noteName.setText(name);
    personViewHolder.noteListCommandListener= mNoteListCommandListener;
}