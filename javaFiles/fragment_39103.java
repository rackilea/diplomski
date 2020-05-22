public void prev(View view) {
      try {
        if(SONG_NUMBER == 0){
              Toast.makeText(getApplicationContext(), "Cannot play previous song", 
                      Toast.LENGTH_SHORT).show();
              prev.setEnabled(false);
        }
        else {
            Toast.makeText(getApplicationContext(), "Previous song", 
                      Toast.LENGTH_SHORT).show();
            mp.reset();
            mp.setDataSource(SD_PATH + songs.get(SONG_NUMBER));
            SONG_NUMBER -=2;
        }
        mp.start();
         } catch(IOException e) {
                Log.v(getString(R.string.app_name), e.getMessage());
         }
           catch(NullPointerException e) {
               Log.v(getString(R.string.prevButton), e.getMessage());
           }
  }