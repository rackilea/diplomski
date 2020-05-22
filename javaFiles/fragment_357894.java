protected void preReadFrom(Class<Object> type, Type genericType, Annotation[] annotations, MediaType mediaType,
                           MultivaluedMap<String, String> httpHeaders,
                           Unmarshaller unmarshaller) throws JAXBException {
    System.out.println("preReadFrom entered");
    super.preReadFrom(type, genericType, annotations, MediaType.WILDCARD_TYPE, httpHeaders, unmarshaller);
    System.out.println("preReadFrom returned from super");

    //new code
    if(unmarshaller instanceof org.eclipse.persistence.jaxb.JAXBUnmarshaller) {
        org.eclipse.persistence.jaxb.JAXBUnmarshaller   moxyUn = ( org.eclipse.persistence.jaxb.JAXBUnmarshaller)unmarshaller;
        moxyUn.getXMLUnmarshaller().setUnmappedContentHandlerClass(CustomUnmapped.class);
    }
//your existing code
    unmarshaller.setEventHandler(new ValidationEventHandler() {
        @Override
        public boolean handleEvent(ValidationEvent event) {
            System.out.println("Entered handleEvent");

            return false;
        }
    });
}