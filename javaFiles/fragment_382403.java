public void onStop() {
    super.onStop();

    if (shouldPlay == false) { // it won't pause music if shouldPlay is true
        player.pause();
    }
}

public void onResume() {
    if (shouldPlay = false) { // it won't pause music if shouldPlay is true
        player.start();
    }
}