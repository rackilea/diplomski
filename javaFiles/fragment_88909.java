public void MainMedia (View view) {
    for (int i=0; i<buttonsas.length; i++) {
        for (int j=0; j<sounds.length; j++){
            if (view.getId() == buttonsas[i] && i == j) {
                MainMedia.release();
                MainMedia = MediaPlayer.create(MainActivity.this, sounds[j]);
                MainMedia.start();
            }
        }
    }
}