class User {
    ...
    public void addNote(Note note) {
        note.user = this;
        notes.add(note);
    }
}