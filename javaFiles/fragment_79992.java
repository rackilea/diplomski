Inflater infl = new Inflater();
    byte[] buf = new byte[1];
    byte[] outputBuf = new byte[512];
    while (!infl.finished()) {
        while (infl.needsInput()) {
            buf[0] = ...next byte from stream...
            infl.setInput(buf);
        }
        int noUnc = infl.inflate(outputBuf);
       // the first "noUnc" bytes of outputBuf contain the next bit of data
    }