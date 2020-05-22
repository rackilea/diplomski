public static String[] getContents(File aFile) throws IOException {
    try (LineNumberReader rdr = new LineNumberReader(new FileReader(aFile))) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (String line = null; (line = rdr.readLine()) != null;) {
            if (rdr.getLineNumber() >= 1500) {
                sb2.append(line).append(File.pathSeparatorChar);
            } else if (rdr.getLineNumber() > 500) {
                sb1.append(line).append(File.pathSeparatorChar);
            }
        }
        return new String[] { sb1.toString(), sb2.toString() };
    }
}