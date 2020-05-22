/**
 * parses String content into a valid XML document.
 * @param content the content to be parsed.
 * @return the parsed document or <tt>null</tt>
 */
private static Document parse(final String content) {
    Document document = null;
    try {
        if (StringUtil.isNull(content)) {
            throw new IllegalArgumentException("cannot parse null "
                    + "content into a DOM object!");
        }

        InputStream is = new ByteArrayInputStream(content
                .getBytes(CONTEXT.getEncoding()));

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = dbf.newDocumentBuilder();
        builder.setEntityResolver(new LocalEntityResolver());
        document = builder.parse(is);
    } catch (Exception ex) {
        LOG.error(Logger.EVENT_FAILURE, "parsing failed "
                + "for content[" + content + "]", ex);
    }

    return document;
}