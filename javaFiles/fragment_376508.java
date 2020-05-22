public Response getEmployee(StreamSource employeeStreamSource){
    //we try to get a hold of the JAXBContext
    ContextResolver<JAXBContext> jaxbResolver = provider.getContextResolver(JAXBContext.class, MediaType.APPLICATION_XML_TYPE);
    JAXBContext jaxbContext= null;
    if(null != jaxbResolver) {
        jaxbContext = jaxbResolver.getContext(Employee.class);
    }
    if(null == jaxbContext) {
        jaxbContext = JAXBContext.newInstance(Employee.class);
    }

    XMLInputFactory xif = XMLInputFactory.newFactory();
    xif.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, false); //Don't blindly parse entities
    xif.setProperty(XMLInputFactory.SUPPORT_DTD, false); //suppress DTD
    XMLStreamReader xsr = xif.createXMLStreamReader(employeeStreamSource); //beging parsing incoming XML

    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
    Employee employee= (Employee) unmarshaller.unmarshal(xsr);  //manually unmarshal

    return Response.status(Status.OK).entity(employee).build();

}