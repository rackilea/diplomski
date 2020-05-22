ZipOutputStream zos = null;
FileInputStream in = null;
try{

    String fullCSVFileName = file.getName();
    String fullFileName = fullCSVFileName.substring(0, fullCSVFileName.length()-3);                     
    String fullZipFileName = fullFileName + "zip";                      
    ZipOutputStream zos = new ZipOutputStream(
            new FileOutputStream("C:\\sourceLocation\\"+fullZipFileName));
    in = new FileInputStream(file.getPath());

    zos.putNextEntry( new ZipEntry(fullZipFileName) );

    byte[] buffer = new byte[1024];

    int len;    
    while ((len = in.read(buffer)) > 0) {
        zos.write(buffer, 0, len);
    }

    zos.finish();

    Logger.debug("Zipping complete!");

}catch(IOException ex){
    Logger.error(ex);
}finally {
    if ( zos != null ) {
        try {
            zos.close();
        } catch ( Exception e ) {}
    }
    if ( in != null ) {
        try {
            in.close();
        } catch ( Exception e ) {}
    }
}