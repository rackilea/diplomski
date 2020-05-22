/**
 * Writes the byte[] to the stream, prefixed by an ASCII STX character and
 * terminated with an ASCII ETX character.
 */
@Override
public void serialize(byte[] bytes, OutputStream outputStream) throws IOException {
    BufferedOutputStream bos = new BufferedOutputStream(outputStream);
    bos.write(STX);
    bos.write(bytes);
    bos.write(ETX);
    bos.flush();
}