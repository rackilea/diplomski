int nextNote = 0;
while (event_loop_condition) {
    .
    .
    .
    if (System.currentTimeMillis()>noteTime[nextNote]) {
       playNote(nextNote++);
    }
    .
    .
    .
}