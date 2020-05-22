private static final XMLOutputProcessor CUSTOMATTRIBUTEQUOTES = new AbstractXMLOutputProcessor() {

    @Override
    protected void printAttribute(final Writer out, final FormatStack fstack,
                            final Attribute attribute) throws IOException {

            if (!attribute.isSpecified() && fstack.isSpecifiedAttributesOnly()) {
                return;
            }
            write(out, " ");
            write(out, attribute.getQualifiedName());
            write(out, "=");

            write(out, "'"); // Changed from "\""

            // JDOM Code used to do this:
            //  attributeEscapedEntitiesFilter(out, fstack, attribute.getValue());
            // Now we instead change to quoting the ' instead of "
            String value = Format.escapeAttribute(fstack.getEscapeStrategy(), value);
            // undo any " escaping that the Format may have done.
            value = value.replaceAll("&quot;", "\"");
            // do any ' escaping that needs to be done.
            value = value.replaceAll("'", "&apos;");
            write(out, value);

            write(out, "'"); // Changed from "\""
    }
};