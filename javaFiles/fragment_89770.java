static String[] readFileInParts(String fname) throws IOException {
    int partSize = 500;
    FileReader fr = new FileReader(fname);
    List<String> parts = new ArrayList<String>();
    char[] buf = new char[partSize];
    int pos = 0;

    for (;;) {
        int nRead = fr.read(buf, pos, partSize - pos);
        if (nRead == -1) {
            if (pos > 0)
                parts.add(new String(buf, 0, pos));
            break;
        }
        pos += nRead;
        if (pos == partSize) {
            parts.add(new String(buf));
            pos = 0;
        }
    }
    return parts.toArray(new String[parts.size()]);
}