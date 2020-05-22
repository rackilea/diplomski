@RequestMapping(value = "/export", method = RequestMethod.GET)
public void getFile(OutputStream out) {
    FileSystemResource resource = new FileSystemResource("c:\file.csv"); 
    try (ZipOutputStream zippedOut = new ZipOutputStream(out)) {
        ZipEntry e = new ZipEntry(resource.getName());
        // Configure the zip entry, the properties of the file
        e.setSize(resource.contentLength());
        e.setTime(System.currentTimeMillis());
        // etc.
        zippedOut.putNextEntry(e);
        // And the content of the resource:
        StreamUtils.copy(resource.getInputStream(), zippedOut);
        zippedOut.closeEntry();
        zippedOut.finish();
    } catch (Exception e) {
        // Do something with Exception
    }        
}