int n = 0;
while (n++ < 100 && ! source.isListening()) {
    Thread.sleep(100;
}
if (!source.isListening()) {
    // failed to start in 10 seconds.
}