public class Main {

    public static void main(String[] args) throws CharacterCodingException {
        CharBuffer chars = CharBuffer.wrap(new char[] {'ÿ', 'ÿ', 'ÿ'});
        CharsetEncoder encoder = StandardCharsets.US_ASCII.newEncoder();
        encoder.onUnmappableCharacter(CodingErrorAction.REPLACE);
        ByteBuffer bytes = encoder.encode(chars);
        bytes.position(0);
        while(bytes.hasRemaining()) {
            System.out.print(bytes.get() + " ");
        }
    }
}