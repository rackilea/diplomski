public Reader parse(InputStream stream, Metadata metadata)
        throws IOException {
    ParseContext context = new ParseContext();
    context.set(Parser.class, parser);
    return new ParsingReader(parser, stream, metadata, context);
}