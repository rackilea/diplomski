final VesselDetails someObj = new VesselDetails();
final JAXBContext context = JAXBContext.newInstance(VesselDetails.class);
final Marshaller marshaller = context.createMarshaller();
marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
StringWriter inputWriter = new StringWriter();
marshaller.marshal(someObj, inputWriter);

Source source = new StreamSource(new StringReader(inputWriter.toString()));
Writer resultWriter = new StringWriter();
Result res = new StreamResult(resultWriter);

TransformerFactory transFactory = TransformerFactory.newInstance();
Transformer transformer = transFactory.newTransformer();
transformer.transform(source, res);

System.out.println(resultWriter.toString());