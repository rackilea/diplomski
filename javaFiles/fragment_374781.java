import javax.xml.xpath.*;

...

XPathFactory xpathFactory = XPathFactory.newInstance();
XPath xpath = xpathFactory.newXPath();
NodeList nodes = (NodeList) xpath.evaluate("//*[@id='USD']", document, XPathConstants.NODESET);