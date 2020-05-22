public static String entityToXML(Object entity) {
    XStream xstream = new XStream(new StaxDriver());

    xstream.autodetectAnnotations(true);
    xstream.registerConverter(new GenericResponseAttributeConverter());
    String xml = xstream.toXML(entity);

    xml = xml.replace("<attribute>", "");
    xml = xml.replace("</attribute>", "");

    return xml;
}