public interface  NoteListCommandListener{
    void updateList();
    void remove(Note n);
}
RVNoteAdapter(NoteListCommandListener noteListCommandListener){
    super();
    mNoteListCommandListener = noteListCommandListener;
}