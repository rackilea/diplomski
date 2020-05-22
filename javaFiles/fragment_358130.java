private ParseObject uploadPDFToParse(File PDFFile, ParseObject po, String columnName){

if(PDFFile != null){
    Log.d("EB", "PDFFile is not NULL: " + PDFFile.toString());
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    BufferedInputStream in = null;
    try {
        in = new BufferedInputStream(new FileInputStream(PDFFile));
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    int read;
    byte[] buff = new byte[1024];
    try {
        while ((read = in.read(buff)) > 0)
        {
            out.write(buff, 0, read);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    try {
        out.flush();
    } catch (IOException e) {
        e.printStackTrace();
    }
    byte[] pdfBytes = out.toByteArray();

    // Create the ParseFile
    ParseFile file = new ParseFile(PDFFile.getName() , pdfBytes);
    po.put(columnName, file);

    // Upload the file into Parse Cloud
    file.saveInBackground();
    po.saveInBackground();
}
return po;
}