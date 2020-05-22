// This returns 'R.raw.note_a', for example
int note = getResources().getIdentifier("note_"+noteChar, "raw", getPackageName()); 

if (resourceID != 0) {
    MediaPlayer mp = MediaPlayer.create(MainActivity.this, note);
    mp.start();
}