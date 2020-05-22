@Override
public void onClick(View v) {
    if (mpButtonClick1.isPlaying()) {
        mpButtonClick1.pause();
    }
    else {
        mpButtonClick1.start();
    }
}