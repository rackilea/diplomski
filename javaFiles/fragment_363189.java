if (icons[currentIndex] != icons[oddClickIndex]) {
    // show images for 1 sec, before flipping back
    myTimer.start(); 
} else {
    pairCounter++;
    if (pairCounter >= MAX_PAIRS) {
        // NOTIFY USER
        // end game
        // reset pairCounter
    }
}