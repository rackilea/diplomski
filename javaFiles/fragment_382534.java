byte[] buf = new byte[2048];
    int ch;
    while ((ch = fIn.read(buf)) >= 0) {
        lOut.write(ch);
        sGen.update(buf, 0, ch);
    }