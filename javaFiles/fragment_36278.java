private void generateTone() {
    int len = (int)Math.ceil((2 * SAMPLE_RATE * msecs / 1000.0d));
    if (len % 2 == 1)
        len = len + 1;
    buf = new byte[len];
    int fadeCount = 1600;
    for (int i = 0; i < buf.length /2; i++) {
        double fadeRate = 1.0;
        double angle = (i * hz / SAMPLE_RATE) * 2.0 * Math.PI;
        if (i<fadeCount) {
            fadeRate = (double)i/(double)fadeCount;
        } else if (i>(buf.length/2)-fadeCount) {
            int bufLength = buf.length;
            int buf = bufLength/2;
            int countDown = buf-i;
            fadeRate = (double)countDown/(double)(fadeCount);
        }
        buf[2*i + 1] = buf[2*i] = (byte) Math.round(
            Math.cos(angle) * 127.0 * vol * fadeRate);
    }
}