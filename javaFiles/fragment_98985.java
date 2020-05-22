private List<Note> readNotes() {
    List<Note> notes = new ArrayList<Note>();
    SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
    Map<String, ?> values = sp.getAll();

    for (String key : values.keySet()) {
        notes.add(new Note(key, (String) values.get(key)));
    }

    return notes;
}