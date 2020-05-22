public PrintWriter getWriter() throws IOException {
    if (sw == null) {
        sw = new StringWriter();
        pw = new PrintWriter(sw);
    }
    return pw;
}