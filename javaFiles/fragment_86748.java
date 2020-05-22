private MediaPlayer media;

     private void stopMusic() {
            if (media != null) {
                media.stop();
                media.release();
                media= null;
           }
        }

button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               stopMusic();
                    media= MediaPlayer.create("you acivityname".this, "mp3file directory");
                    media.start();
            }
        });