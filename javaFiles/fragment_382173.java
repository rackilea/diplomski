long startTime = System.currentTimeMillis();
long timeElapsed;
do {
    // Get user input
    .
    .


    // Process input
    .
    .

    // Check time elapsed
    timeElapsed = (System.currentTimeMillis() - startTime) / 1000;

} while (timeElapsed < 30);