JAXBContext jaxbContext = JAXBContext.newInstance(UserEntities.class);
Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

StringWriter sw = new StringWriter();
jaxbMarshaller.marshal(users, sw);
String xmlString = sw.toString();

System.out.println(xmlString);