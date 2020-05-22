JAXBContext context = JAXBContext.newInstance(Req.class);
Marshaller marshaller = context.createMarshaller();
StringWriter sw = new StringWriter();
marshaller.marshal(instanceOfReq, sw);

String xmlString = sw.toString();