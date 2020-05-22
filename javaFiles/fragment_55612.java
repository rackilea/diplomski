try {
    OutputStream out = new FileOutputStream(new File(uploadedFileLocation));
    int read = 0;
    byte[] bytes = new byte[1024];

    // delete the following line, you already opened the output stream right after the `try`.
    out = new FileOutputStream(new File(uploadedFileLocation));