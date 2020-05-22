JAXBContext context;

try {
    context = JAXBContext.newInstance(heartbeat.getClass());
    StringWriter writer = new StringWriter();
    writer.append("<?xml version=\"1.0\"?>");
    Marshaller marshaller = context.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);

    heartbeat.setHeader(header);
    heartbeat.setHeartbeatEvent(event);

    marshaller.marshal(heartbeat, writer);
    String stringXML = writer.toString();
    return stringXML;

} catch (JAXBException e) {
    throw new RuntimeException("Problems generating XML in specified "
            + "encoding, underlying problem is " + e.getMessage(),
            e);
}