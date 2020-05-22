final static int MAX_STRING_LENGTH = 10240; // arbitrary number
private final static ByteBuffer stringBytes = ByteBuffer.allocate(MAX_STRING_LENGTH);

static String readStringFromQTStream(final ObjectInputStream in) throws IOException {
  if (in.available() < (Integer.SIZE / 8)) { // check that there are at least 4 bytes for the length
    throw new IOException("Illegal data received: expected integer but only got " + in.available() + " bytes");
  }
  final int stringLength = in.readInt();
  if (stringLength == 0xFFFFFFFF) { // Qt for null string
    return null;
  }
  if ((stringLength < 0) || (stringLength > stringBytes.capacity())) { // check for malformed data
    throw new IOException("Illegal data received: string with supposed length of " + stringLength + " bytes");
  }

  stringBytes.clear(); // global var, not thread-safe!
  in.readFully(stringBytes.array(), 0, stringLength);
  stringBytes.flip();
  return StandardCharsets.UTF_8.decode(stringBytes).toString();
}