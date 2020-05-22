final CharsetEncoder encoder = StandardCharsets.UTF_8.newEncoder();
final CharBuffer buffer = CharBuffer.wrap(input);
final ByteBuffer encodedBuffer = ByteBuffer.allocate(BUFFER_SIZE);
CoderResult coderResult;

while (buffer.hasRemaining()) {
    coderResult = encoder.encode(buffer, encodedBuffer, false);
    if (coderResult.isError()) {
        throw new IllegalArgumentException(
                "Invalid code point in input string");
    }
    encodedBuffer.flip();
    // do stuff with encodedBuffer
    encodedBuffer.clear();
}

// required by encoder: call encode with true to indicate end
coderResult = encoder.encode(buffer, encodedBuffer, true);
if (coderResult.isError()) {
    throw new IllegalArgumentException(
            "Invalid code point in input string");
}
encodedBuffer.flip();
// do stuff with encodedBuffer
encodedBuffer.clear(); // if still required