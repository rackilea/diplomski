JAXBContext jaxbContext = JAXBContext.newInstance(Transforms.class);
Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
InputStream is = new FileInputStream(file);
XMLStreamReader xsr = XMLInputFactory.newFactory().createXMLStreamReader(is);
XMLReaderWithoutNamespace xr = new XMLReaderWithoutNamespace(xsr);
transforms = (Transforms) jaxbUnmarshaller.unmarshal(xr);