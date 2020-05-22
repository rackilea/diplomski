for (int i = 0; i < 10; i ++) {
    runMethod();
}
int count = 10;
for (;;) {
    long begin = System.currentTimeMillis();
    for (int i = 0; i < count; i ++)
        runMethod();
    long end = System.currentTimeMillis();
    if ((end - begin) < 10000) {
        count *= 2;
        continue;
    }
    reportElapsedTime((double)(end - begin) / count);
}