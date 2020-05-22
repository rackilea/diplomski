ServletFileUpload upload = new ServletFileUpload();

    FileItemIterator iterator = null;
    try {
        iterator = upload.getItemIterator(request);
        while (iterator.hasNext()) {
            FileItemStream item = iterator.next();
            String filename = item.getName();
        }

    } catch (FileUploadException e) {
        // handle the error here
    }