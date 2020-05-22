if (sound==1){
            mp = MediaPlayer.create(getApplicationContext(), R.raw.munfasil);
            mp.start();

            Toast.makeText(getApplicationContext(), 
                               "Sound is Play", Toast.LENGTH_LONG).show();

        }