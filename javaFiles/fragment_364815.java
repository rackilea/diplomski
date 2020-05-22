Test test = new Test();
test.data = "Hello, World!";

JAXBContext context = JAXBContext.newInstance(Test.class);
Marshaller marshaller = context.createMarshaller();
marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
marshaller.marshal(test, System.out);