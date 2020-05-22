Runnable[] tasks = { /* task1, task2, ..., taskN */ } ; // N elements
int[] delays = { 100, 9, 22, ..., 1000 }; // N-1 elements (delay after task1, ..., task(N-1)

KeyFrame[] frames = new KeyFrame[tasks.length] ;
int cumulativeMillis = 0 ;
for (int i = 0; i < tasks.length; i++) {
    frames[i] = new KeyFrame(Duration.millis(cumulativeMillis), event -> tasks[i].run());
    if (i < delays.length) {
        cumulativeMillis += delays[i] ;
    }
}
Timeline timeline = new Timeline(frames);
timeline.play();