String xml = "<field attribute1=\"A\"" +
                   " attribute2=\"B\"" +
                   " attribute3=\"C\"" +
                   " attribute4=\"D\"" +
                   " foo=\"Bar\" />";
JAXBContext jaxbContext = JAXBContext.newInstance(Field.class);
Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
Field field = (Field) unmarshaller.unmarshal(new StringReader(xml));
System.out.println("field.attribute1 = " + field.attribute1);
System.out.println("field.attribute2 = " + field.attribute2);
System.out.println("field.attribute3 = " + field.attribute3);
System.out.println("field.attributes = " + field.attributes);