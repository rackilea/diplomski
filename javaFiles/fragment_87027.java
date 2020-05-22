private <U> void fun(U u, Result result) {
  JAXBContext context = JAXBContext.newInstance(u.getClass());
  Marshaller marshaller = context.createMarshaller();
  marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
  marshaller.marshal(u, result);
}