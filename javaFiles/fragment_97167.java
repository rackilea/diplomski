Document doc = DocumentBuilderFactory.newInstance()
                  .newDocumentBuilder().newDocument();
Element consumerInfo = doc.createElement("consumerInfo");
consumerInfo.setTextContent("some info");
doc.appendChild(consumerInfo);
TPAExtensionsType tp = new TPAExtensionsType();
tp.getAny().add((Element) doc.getFirstChild());

JAXBContext jc = JAXBContext.newInstance(TPAExtensionsType.class);
Marshaller marshaller = jc.createMarshaller();
marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
marshaller.marshal(tp, System.out);