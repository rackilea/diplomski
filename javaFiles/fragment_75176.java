public void buildTrackAndStart() {
    // ...
    try {
        sequencer.setSequence(sequence);
        sequencer.setLoopCount(Integer.MAX_VALUE); // play forever
    } catch(Exception e) {
    // ...
}