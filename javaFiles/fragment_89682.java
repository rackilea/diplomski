public static <T> String marshall(T data) {
    try {
        JAXBContext jaxbContext = JAXBContext.newInstance(data.getClass());
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        StringWriter stringWriter=new StringWriter();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        jaxbMarshaller.marshal(data, stringWriter);
        return stringWriter.toString();
    } catch (JAXBException e) {
        e.printStackTrace();
    }
    return null;
}