protected double readDouble(InputStream stream) throws IOException {

    return Double.longBitsToDouble(((long) read(stream) & 0xff) 
                                 | ((long) (read(stream) & 0xff) << 8)
                                 | ((long) (read(stream) & 0xff) << 16)
                                 | ((long) (read(stream) & 0xff) << 24)
                                 | ((long) (read(stream) & 0xff) << 32)
                                 | ((long) (read(stream) & 0xff) << 40)
                                 | ((long) (read(stream) & 0xff) << 48)                     
                                 | ((long) (read(stream) & 0xff) << 56));  }