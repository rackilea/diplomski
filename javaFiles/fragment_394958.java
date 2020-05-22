Config(String fn) throws IOException {
    this.filename = fn;
    if (filename.startsWith("--")) {
        // inline config
        String config = filename.substring(2).replace("\\n", "\n");
        reader = new StringReader(config);