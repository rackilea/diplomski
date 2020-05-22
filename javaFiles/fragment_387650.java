private void initNewBuffer() {
    try {
      buffSize = channel.read(buffer);
      buffer.position(0);
      charBuffer = StandardCharsets.UTF_8.decode(buffer);
      if (buffSize > 0) {
        byte edgeByte = buffer.array()[buffSize - 1];
        if (edgeByte == (byte) 0xd0 ||
            edgeByte == (byte) 0xd1 ||
            edgeByte == (byte) 0xc2 ||
            edgeByte == (byte) 0xd2 ||
            edgeByte == (byte) 0xd3
        ) {
          channel.position(channel.position() - 1);
          charBuffer.limit(charBuffer.limit()-1);
        }
      }
      buffer.position(0);
    } catch (IOException e) {
      throw new RuntimeException("Error reading file: {}", e);
    }
  }