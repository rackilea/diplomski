// Note note
// List<String> artist

Observable.fromIterable(artistIds) // Observable<String>
    .flatMapSingle(this::getUser) // Observable<User>
    .toList() // Single<List<User>>
    .subscribe( artists -> {
        note.setArtists(artists);
        loadNoteResults.NoteLoaded(note, true);
    });