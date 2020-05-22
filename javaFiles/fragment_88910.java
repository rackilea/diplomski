public void MainMedia (View view) {
    // Traverse the buttonsas array to get the item the user just pressed.
    for (int i=0; i<buttonsas.length; i++) {
        // Check whether the item we got from the array is equal to the item we received as a parameter
        if (view.getId() == buttonsas[i]) {
            MainMedia.release();

            // Since the sounds and buttons have a relation in the same position in two different arrays,
            // just get the position we have depending on the selected item.
            MainMedia = MediaPlayer.create(MainActivity.this, sounds[i]);
            MainMedia.start();
        }
    }
}