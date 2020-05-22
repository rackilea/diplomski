// the Saxon processor object
Processor saxon = new Processor(false);

// compile the query
XQueryCompiler compiler = saxon.newXQueryCompiler();
XQueryExecutable exec = compiler.compile(new File("yours.xqy"));

// parse the string as a document node
DocumentBuilder builder = saxon.newDocumentBuilder();
String input = "<xml>...</xml>";
Source src = new StreamSource(new StringReader(input));
XdmNode doc = builder.build(src);

// instantiate the query, bind the input and evaluate
XQueryEvaluator query = exec.load();
query.setContextItem(doc);
XdmValue result = query.evaluate();