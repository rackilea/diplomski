String yourXmlString;  
SAXParserFactory spf = SAXParserFactory.newInstance();  
SAXParser sp = spf.newSAXParser();  
XMLReader xr = sp.getXMLReader();  

/* Create a new instance of the class generated */  
YourHandler handler = new YourHandler ();  
xr.setContentHandler(handler);  

InputSource inputSource = new InputSource();  
inputSource.setEncoding("UTF-8");  
inputSource.setCharacterStream(new StringReader(response));  

/* Start Parsing */  
xr.parse(inputSource);  
/* Parsing Done. */