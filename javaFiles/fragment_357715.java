public void playdk1 (View view) {
    if (dk1.isPlaying() == true) {
        dk1.stop();
        dk1.reset();

        return;
    }

    if (dk2.isPlaying() == true) {
        dk2.stop();
        dk2.reset();
    }

    dk1.start();
    dk1.setLooping(true);
}

public void playdk2 (View view) {
    if (dk2.isPlaying() == true) {
        dk2.stop();
        dk2.reset();

        return;
    }

    if (dk1.isPlaying() == true) {
        dk1.stop();
        dk1.reset();
    }

    dk2.start();
    dk2.setLooping(true);
}