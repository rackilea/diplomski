public static String prettyPrintXml(String xml) {

        final StringWriter sw;

        try {
            final OutputFormat format = OutputFormat.createPrettyPrint();
            format.setSuppressDeclaration(true);
            final org.dom4j.Document document = DocumentHelper.parseText(xml);
            sw = new StringWriter();
            final XMLWriter writer = new XMLWriter(sw, format);
            writer.write(document);
        } catch (Exception e) {
            throw new RuntimeException("Error pretty printing xml:\n" + xml, e);
        }
        return sw.toString();
    }