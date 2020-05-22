public void Abspielen(String Datei) {

    try {

        stopKnopf = findViewById(R.id.fab2);
        stopKnopf.show();

        try  {
            if (AndreasPlayer.isPlaying()) {
                AndreasPlayer.reset();
            }
        } catch (Exception ex) {

        }

        AndreasPlayer = MediaPlayer.create(MainActivity.this, getResources().getIdentifier(Datei, "raw", getPackageName()));

        AndreasPlayer.start();

        stopKnopf.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AndreasPlayer.reset();
                stopKnopf.hide();
            }
        });

        AndreasPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                AndreasPlayer.reset();
                stopKnopf.hide();
            }

        });

    } catch (Exception e) {
        Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_LONG).show();
    }
}