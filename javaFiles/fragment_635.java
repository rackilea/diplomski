Charset charset = Charset.forName("UTF-8");
CharsetDecoder decoder = charset.newDecoder();
String data = "";
int old_position = byteBuffer.position();
try {
    data = decoder.decode(java.nio.HeapByteBuffer[pos=3208lim=3216cap=14616]).toString();
    byteBuffer.position(old_position);
    System.out.println(data);
} catch (CharacterCodingException e) {
    e.printStackTrace();
}