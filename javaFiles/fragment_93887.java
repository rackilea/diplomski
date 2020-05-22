InputStream inputStream = null; // input stream of the upload file

    // obtains the upload file part in this multipart request
    Part filePart = request.getPart("file1");
    if (filePart != null) {
        // prints out some information for debugging
        System.out.println(filePart.getName());
        System.out.println(filePart.getSize());
        System.out.println(filePart.getContentType());

        // obtains input stream of the upload file
        inputStream = filePart.getInputStream();
    }