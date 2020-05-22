InputStream is = null;
    OutputStream os = null;
    try {
        is = new FileInputStream(new File("path/to/img/src"));
        os = new FileOutputStream(new File("path/to/img/dest"));
        byte[] buffer = new byte[8192];
        int length;
        while ((length = is.read(buffer)) > 0) {
            os.write(buffer, 0, length);
        }
    } finally {
        is.close();
        os.close();
    }