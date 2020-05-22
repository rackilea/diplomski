import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.StreamResult;

Object jaxbElement = // The object you want to marshall using jaxb.

JAXBContext context = JAXBContext.newInstance(jaxbElement.getClass());
Marshaller marshaller = context.createMarshaller();
OutputStream out = // Here your destination, FileOutStream, ByteOutStream etc
DOMResult domResult = new DOMResult();
marshaller.marshal(jaxbElement, domResult);

Transformer transformer = TransformerFactory.newInstance().newTransformer();
transformer.setOutputProperty(OutputKeys.INDENT, "yes");
transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
transformer.transform(new DOMSource(domResult.getNode()), new StreamResult(out));