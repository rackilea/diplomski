public static void main(String[] args) throws Exception {
    File file = new File("/Users/jason/docstore/example_received_regular.msg");
    AutoDetectParser parser = new AutoDetectParser();
    BodyContentHandler handler = new BodyContentHandler(-1);
    Metadata tikaMetadata = new Metadata();
    InputStream input = TikaInputStream.get(file, tikaMetadata);
    parser.parse(input, handler, tikaMetadata, new ParseContext());
    String[] names = tikaMetadata.names();
    Arrays.sort(names);
    for (String name : names) {
        System.out.println(name + ": " + tikaMetadata.get(name));
    }
}