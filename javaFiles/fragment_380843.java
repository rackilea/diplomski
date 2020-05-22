// Create a new file upload handler
ServletFileUpload upload = new ServletFileUpload();

// Parse the *raw* request
FileItemIterator iter = upload.getItemIterator(request.raw());
while (iter.hasNext()) {
    FileItemStream item = iter.next();
    String name = item.getFieldName();
    InputStream stream = item.getInputStream();
    if (item.isFormField()) {
        System.out.println("Form field " + name + " with value "
            + Streams.asString(stream) + " detected.");
    } else {
        System.out.println("File field " + name + " with file name "
            + item.getName() + " detected.");
        // Process the input stream
        ...
    }
}