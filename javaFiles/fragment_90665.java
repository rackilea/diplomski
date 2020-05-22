Bundle extras = getIntent().getExtras();
            if (extras != null) {

             String fname=extras.get("soundfile");

        int resID=getResources().getIdentifier(fname, "raw", getApplicationContext().getPackageName());

             MediaPlayer mediaPlayer=MediaPlayer.create(this,resID);
            mediaPlayer.start();

            }