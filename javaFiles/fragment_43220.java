Note match = null;

for (Note note : mNotes) {
    if (note.getTitle().contains(userinputString)) {
        match = note;
        break;
    }
}

if (match != null) {
    // Found a match
    previewResultTextview.setText(match.getTitle());
}