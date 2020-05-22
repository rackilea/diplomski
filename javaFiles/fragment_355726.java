map.put('a', R.raw.note_a); // Name your resources based on the notes

...

char noteChar = 'a'; // For example
Integer note = map.get(noteChar);
if (note != null) {
    MediaPlayer mp = MediaPlayer.create(MainActivity.this, note);
    mp.start();
}