try {
    final InputStream in = new FileInputStream(file);
    try {
        // ...
    } finally {
        in.close();
    }
} catch(IOException e) {
    // handle exception
}