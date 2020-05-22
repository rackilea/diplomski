public void addNote(Note note)
{
    if (note == null || note.noteManager != this || notes.contains(note)) {
        return;
    }
    note.noteManager = this;
    notes.add(note);