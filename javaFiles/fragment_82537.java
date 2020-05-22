byte[] raw = content.getContent();
 ContentHandler handler = new BodyContentHandler();
 Metadata metadata = new Metadata();
 Parser parser = new AutoDetectParser();
 parser.parse(new ByteArrayInputStream(raw), handler, metadata, new ParseContext());
 LOG.info("content: " + handler.toString());