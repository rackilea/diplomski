if (movieStart == 0) {
    movieStart = (int) now;
}

if (mMovie != null) {
    int relTime = (int) (now - moviestart);

mMovie.setTime(relTime < mMovie.duration() ? relTime : mMovie.duration());
mMovie.draw(canvas, 
    getWidth() / 2 - mMovie.width() / 2, 
    getHeight() / 2 - mMovie.height() / 2);

if (relTime >= mMovie.duration()) {
    // move has played once
    fireAction();  // or set a member variable or whatever
}