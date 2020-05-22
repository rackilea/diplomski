public static XMLPacket unmarshall(String xml) {
    XStream xstream = new XStream(new DomDriver());

    return (XMLPacket)xstream.fromXML(xml);

}