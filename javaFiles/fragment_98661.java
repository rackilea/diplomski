CharsetDecoder decoder = Charset.forName(encoding).newDecoder();
    CharBuffer cb = CharBuffer.allocate(100);
    decoder.decode(ByteBuffer.wrap(buffer1), cb, false);
    decoder.decode(ByteBuffer.wrap(buffer2), cb, false);
    ...
    decoder.decode(ByteBuffer.wrap(bufferN), cb, true);
    cb.position(0);
    return cb.toString();