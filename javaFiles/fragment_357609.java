private static final char[] protectingCharacters = {
        ')', ']', '}', '\'', ','
};

static Reader stripProtection(final Reader reader)
        throws IOException {
    // Allocating a temporary buffer
    final char[] buffer = new char[protectingCharacters.length];
    // Check if the given Reader instance supports reading ahead, and wrap if necessary
    // This is necessary in order to restore the reader position
    final Reader normalizedReader = reader.markSupported() ? reader : new BufferedReader(reader);
    // Memorizing the current position telling the reader to limit its internal buffer size just with five characters
    normalizedReader.mark(protectingCharacters.length);
    // Reading five characters to the buffer
    // We don't need to check how many characters were read -- we'll check it below
    normalizedReader.read(buffer, 0, protectingCharacters.length);
    // Not a protecting mark?
    if ( !Arrays.equals(protectingCharacters, buffer) ) {
        // Then just rewind the reader pointer to the position stored with the mark() invocation
        normalizedReader.reset();
    }
    // Or assume that skipping five characters is fine
    return normalizedReader;
}