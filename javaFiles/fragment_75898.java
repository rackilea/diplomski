if (CreateNoteActivity.didClick) { // User is saving an existing note
     Note anote = notes.getItem(passedNoteId);
     anote.setTitle(passedTitle);
     anote.setDescription(passedDescription);
} else { // User is creating a new note
     notes.add(new Note(passedTitle, passedDescription));
}