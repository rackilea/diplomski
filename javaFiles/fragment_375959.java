SAXParserFactory spf = SAXParserFactoryImpl.newInstance();
spf.setNamespaceAware(true);
spf.setValidating(false);
spf.setFeature("http://xml.org/sax/features/validation", false);
spf.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
spf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
SAXParser sp = spf.newSAXParser() ;
Source src = new SAXSource ( sp.getXMLReader(), new InputSource( input.getAbsolutePath() ) ) ;
String resultFileName = input.getAbsolutePath().replaceAll(".xml$", ".cooked.xml" ) ;
Result result = new StreamResult( new File (resultFileName) ) ;
TransformerFactory tf = TransformerFactory.newInstance();
Source xsltSource = new StreamSource( new File ( COOKER_XSL ) );
xsl = tf.newTransformer( xsltSource ) ;
xsl.setParameter( "srcDocumentName", input.getName() ) ;
xsl.setParameter( "srcDocumentPath", input.getAbsolutePath() ) ;

xsl.transform(src, result );