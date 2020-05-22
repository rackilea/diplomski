playAllNotes() {
    for (int i=0; i<numberOfNotes; i++) {
        Thread.sleep(noteTime[i]-System.currentTimeMillis());
        playNote(i);
    }
}