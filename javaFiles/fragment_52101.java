Processor proc = new Processor();

InputStream input = new FileInputStream("/tmp/g.html");
XMLReader reader = new Parser();
reader.setFeature(Parser.namespacesFeature, false);
Source source = new SAXSource(parser, input);

DocumentBuilder builder = proc.newDocumentBuilder();
XdmNode input = builder.build(source);

XPathCompiler compiler = proc.newXPathCompiler();
XdmValue result = compiler.evaluate("//span", input);
System.out.println(result.size());