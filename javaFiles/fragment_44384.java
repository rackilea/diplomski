//Obtain a TransformerFactory
//Obtain a Source for your stylesheet, like a StreamSource
Transformer transformer = transformerFactory.newTransformer(source);

//Next, create an Unmarshaller from a JAXBContext
Unmarshaller unmarshaller = context.createUnmarshaller();

//Create a JAXBResult with the Unmarshaller
JAXBResult result = new JAXBResult(unmarshaller);

//Obtain a Source for your input XML, and transform
transformer.transform(inputSource, result);

//Get the JAXBElement from the result
final JAXBElement<?> jaxbEl = (JAXBElement<?>)result.getResult();

//And now your unmarshalled Java bean from the JAXBElement
Object bean = jaxbEl.getValue();