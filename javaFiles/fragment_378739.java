public static String unzipString(byte[] zbytes) {
    String charsetName = "ISO-8859-1";
    String unzipped = null;
    try {
        // Add extra byte to array when Inflater is set to true
        byte[] input = new byte[zbytes.length + 1];
        System.arraycopy(zbytes, 0, input, 0, zbytes.length);
        input[zbytes.length] = 0;
        ByteArrayInputStream bin = new ByteArrayInputStream(input);
        InflaterInputStream in = new InflaterInputStream(bin);
        ByteArrayOutputStream bout = new ByteArrayOutputStream(512);
        int b;
        while ((b = in.read()) != -1) {
            bout.write(b); 
        }
        bout.close();
        unzipped = bout.toString(charsetName);
    } catch (IOException e) { 
        e.printStackTrace();
    }
    return unzipped;
 }