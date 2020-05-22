Metadata metadata = new Metadata();
metadata.set(Metadata.RESOURCE_NAME_KEY, filename);
ParseContext context = new ParseContext();

Parser parser = new AutoDetectParser();
parser.parse(input, textHandler, metadata, new ParseContext());