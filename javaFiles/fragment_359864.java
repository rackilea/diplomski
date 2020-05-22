XQDataSource ds = new SaxonXQDataSource();
XQConnection xqjc = ds.getConnection();
XQPreparedExpression xqje = xqjc.prepareExpression(new FileInputStream("xml\\foo.xquery"));

XMLInputFactory factory = XMLInputFactory.newInstance();
XMLStreamReader streamReader = factory.createXMLStreamReader(new FileReader("xml\\foo.xml"));

xqje.bindDocument(XQConstants.CONTEXT_ITEM,streamReader, xqjc.createDocumentType());

XQResultSequence xqjs  = xqje.executeQuery();

xqjs.writeSequence(System.out, null);