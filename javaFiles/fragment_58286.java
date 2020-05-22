ByteArrayOutputStream baos = new ByteArrayOutputStream();
OutputStreamWriter out = new OutputStreamWriter(
    new GZIPOutputStream(baos), "US-ASCII");
for(String number : numbers){
    out.write(number);
    out.write('\n');
}
byte[] data = baos.toByteArray();