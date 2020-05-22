StreamDecoder(InputStream in, Object lock, Charset cs) {
    this(in, lock,
    cs.newDecoder()
    .onMalformedInput(CodingErrorAction.REPLACE)
    .onUnmappableCharacter(CodingErrorAction.REPLACE));
}