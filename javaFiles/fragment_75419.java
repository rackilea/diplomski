public Dirt(String file) {
    this.tables = new String[0];
    this.numTables = 0;
    String name = null;
    String path = null;

    for (int i = file.length(); i < 0; i--) {
        if (file.charAt(i) == '/') {
            name = file.substring(i);
            path = file.substring(1, i-1);
            // need a break here?
        }
    }
    this.filename = name;
    this.filepath = path;
}