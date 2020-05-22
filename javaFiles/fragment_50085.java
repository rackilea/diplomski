public byte[] read(int bytes) throws IOException {
    byte b[] = new byte[bytes];
    int pos = 0;
    while (pos < b.length) {
       int nosRead = in.read(b, pos, b.length - pos);
       if (nosRead == -1) {
          return null;  // Not the best idea ... see below.
       } else {
          pos += nosRead;
       }
    }
    return b;
}