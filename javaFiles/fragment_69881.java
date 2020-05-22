HttpResponse response = services.getFileByPayloadID("12345-abcde");
ByteArrayOutputStream buf = new ByteArrayOutputStream();
BufferedInputStream bis = null;
try {
    bis = new BufferedInputStream(response.getEntity().getContent());
} catch (UnsupportedOperationException | IOException e) {
    e.printStackTrace();
}
String filePath = "c:\\sample.zip";
BufferedOutputStream bos = null;
try {
    bos = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
    String output = "";
    int inByte;
    String charset = "your-charset"; //using charset to ensure that you can parse string correct to compare it.
    boolean start = false;
    while((inByte = bis.read()) != -1) {
        if (!start){
            buf.write((byte) inByte);
            output = buf.toString(charset);
            if (output.endsWith("name=\"Payload\"")){ //compare with your pattern to determine when will start write to file
                start = true;
            }
        }
        if(start){
            bos.write(inByte);
        }
    }
} catch (IOException e) {
    e.printStackTrace();
} finally {
    try {bis.close();} catch (Exception e) {}
    try {bos.close();} catch (Exception e) {}
}