public static String beanToXMLString(final Object bean) {
    String returnvalue = null;
    final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    final XMLEncoder xmlEncoder = new XMLEncoder(new BufferedOutputStream(byteArrayOutputStream));
    xmlEncoder.writeObject(bean);
    xmlEncoder.close();
    returnvalue = byteArrayOutputStream.toString();
    return returnvalue;
}

public static Object beanFromXMLString(final String xml) {
    Object returnvalue = null;
    final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xml.getBytes());
    final XMLDecoder xmlDecoder = new XMLDecoder(new BufferedInputStream(byteArrayInputStream));
    returnvalue = xmlDecoder.readObject();
    xmlDecoder.close();
    return returnvalue;
}