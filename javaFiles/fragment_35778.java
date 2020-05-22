@Override
public void doGet(HttpServletRequest req, HttpServletResponse resp) throws
        ServletException, IOException {
    // Process parameters and do other stuff you need

    resp.setContentType("application/zip");
    // Indicate that a file is being sent back:
    resp.setHeader("Content-Disposition", "attachment;filename=template.zip");

    try (ZipOutputStream out = new ZipOutputStream(resp.getOutputStream())) {
        // Here go through your template / folders / files, optionally 
        // filter them or replace them with the content you want to include

        // Example adding a file to the output zip file:
        ZipEntry e = new ZipEntry("some/folder/image.png");
        // Configure the zip entry, the properties of the file
        e.setSize(1234);
        e.setTime(System.currentTimeMillis());
        // etc.
        out.putNextEntry(e);
        // And the content of the file:
        out.write(new byte[1234]);
        out.closeEntry();

        // To add another file to the output zip,
        // call putNextEntry() again with the entry,
        // write its content with the write() method and close with closeEntry().

        out.finish();
    } catch (Exception e) {
        // Handle the exception
    }
}