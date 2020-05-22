org.xml.sax.InputSource inputSource = new 
org.xml.sax.InputSource('c:/users/ndh/foobar.xml');
javax.xml.xpath.XPath xpath = 
    javax.xml.xpath.XPathFactory.newInstance().newXPath();
String text = (String)xpath.evaluate('/foo/bar/text()', 
    inputSource, javax.xml.xpath.XPathConstants.STRING);