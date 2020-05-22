void blurParallel(Picture source, int x, int y, int w, int h) {
    int processors = Runtime.getRuntime().availableProcessors();
    blurParallel(source, x, y, w, h, processors * 4);
}

void blurParallel(Picture source, int x, int y, int w, int h, int parallelism) {
    if (parallelism <= 1) {
         blurSequential(source, x, y, w, h);
    } else if (w >= THRESHOLD_WIDTH) {
         int m = w / 2;
         async blurParallel(source, x, y, m, h, parallelism / 2);
         blurParallel(source, x + m, y, w - m, h, parallelism / 2);
         await
    } else if (h >= THRESHOLD_HEIGHT) {
         int m = h / 2;
         async blurParallel(source, x, y, w, m, parallelism / 2);
         blurParallel(source, x, y + m, w, h - m, parallelism / 2);
         await
    } else {
         blurSequential(source, x, y, w, h);
    }
}