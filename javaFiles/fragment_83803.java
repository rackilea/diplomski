ObjectFactory objectFactory = new ObjectFactory();

Element element = new Element();
element.setSub1("one");
element.setSub2(objectFactory.createSub2("two"));

JAXBContext context = JAXBContext.newInstance(ObjectFactory.class, Element.class);

Marshaller marshaller = context.createMarshaller();
marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
marshaller.marshal(element, System.out);