Path p = Paths.get("C:\\test", "foo.txt");
System.out.println(Files.exists(p));
try {
    Files.createFile(p);
    System.out.println(Files.exists(p));
    try (BufferedWriter out = Files.newBufferedWriter(p, Charset.defaultCharset(), StandardOpenOption.DELETE_ON_CLOSE)) {
        out.append("Hello, World!");
        out.flush();
        try (BufferedReader in = Files.newBufferedReader(p, Charset.defaultCharset())) {
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
} catch (IOException ex) {
    ex.printStackTrace();
}
System.out.println(Files.exists(p));