public String getResponseXML(StudentDetailsResponse response) throws JAXBException
{
     StringWriter sw = new StringWriter();
    JAXBContext jaxbContext = JAXBContext.newInstance(StudentDetailsResponse.class);
    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    jaxbMarshaller.marshal(response,  new StreamResult(sw));
    return sw.toString();
}