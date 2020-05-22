appsink.connect(new AppSink.NEW_BUFFER() {
@Override public void newBuffer(Element elem, Pointer userData) {
AppSink appsink = (AppSink) elem;
Buffer buffer = appsink.pullBuffer();  //get the stream data as an input to external 
                                       //applications

/*
// Create a character ByteBuffer
CharBuffer cbuf = byteBuffer.asCharBuffer();
*/

ByteBuffer byteBuffer = buffer.getByteBuffer();
byte[] bytearray = new byte[byteBuffer.remaining()];
byteBuffer.get(bytearray);
String s = new String(bytearray);
//InputStream is = new ByteArrayInputStream(bytearray);
// System.out.print(buffer.getSize()+"\n");
//  System.out.print(s+"\n");

//Do whatever with this buffer inside string here e.g. parsing text content

...

byteBuffer.clear();
buffer.dispose();
buffer = null;

}
});