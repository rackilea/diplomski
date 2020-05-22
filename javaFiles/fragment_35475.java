DiskFileItemFactory factory = new DiskFileItemFactory(thresholdBytes, tempDir);
ServletFileUpload upload = new ServletFileUpload(factory);
upload.setFileSizeMax(maxFileSize);

for (FileItem item : upload.parseRequest(request)) {
    // Save the file
    File uploadedFile = new File(myPath);
    item.write(uploadedFile);
}