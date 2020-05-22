@RequestMapping(value = "/export", method = RequestMethod.GET)
public void getFile(HttpServletResponse response) {
    FileSystemResource resource = new FileSystemResource("c:\file.csv"); 
    response.setContentType("application/zip");
    response.setHeader("Content-Disposition", "attachment; filename=file.zip");

    try (ZipOutputStream zippedOut = new ZipOutputStream(response.getOutputStream())) {
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