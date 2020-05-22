private int getMoreData() throws IOException {
    if (done) return -1;
    int readin = input.read(ibuffer);
    if (readin == -1) {
        done = true;
        try {
            obuffer = cipher.doFinal();
        }
        catch (IllegalBlockSizeException e) {
            throw new IOException(e);
        }
        catch (BadPaddingException e) {
            throw new IOException(e);
        }
        if (obuffer == null)
            return -1;
        else {
            ostart = 0;
            ofinish = obuffer.length;
            return ofinish;
        }
    }
    try {
        obuffer = cipher.update(ibuffer, 0, readin);
    } catch (IllegalStateException e) {obuffer = null;};
    ostart = 0;
    if (obuffer == null)
        ofinish = 0;
    else ofinish = obuffer.length;
    return ofinish;
}