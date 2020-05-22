final OptionalInt firstInvalidChar = line.chars()
    .parallel()
    .filter(ch -> !Charset.forName("ISO-8859-1").newEncoder().canEncode((char) ch))
    .findFirst();

if (firstInvalidChar.isPresent()) {
    throw new EncodingException(
        "The first invalid char is: " + (char) firstInvalidChar.getAsInt()
    );
}