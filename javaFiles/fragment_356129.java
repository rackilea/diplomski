int pos = 0;
    while (pos < bytes.length) {
        int l;
        if ((l = isr.read(bytes, pos, bytes.length - pos)) == -1) {
            throw new EOFException();
        }
        pos += l;
    }