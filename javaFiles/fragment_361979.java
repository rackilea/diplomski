private int pos = 0;
@Override
protected void onPause() {
        super.onPause();

       if(oursong != null){
           pos = oursong.getCurrentPosition();
           oursong.release();
           oursong = null;
        }
}

@Override
protected void onResume(){
      super.onResume();

     /*
      * This is the important part, basically since your releasing the song
      * in onPause() you are getting rid of its reference, in this case check
      * if your song is null then if it is re-create it, else you can reuse the
      * the original, but i suspect that calling release() in onPause() allows the
      * song to get cleaned up by Java's Garbage Collector.
      */
     oursong = MediaPlayer.create(MainActivity.this, R.raw.a);
     oursong.seekTo(pos); // You will probably want to save an int to restore here
     oursong.start();
}