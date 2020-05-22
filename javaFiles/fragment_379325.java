Processor proc = new Processor(false);
XsltCompiler comp = new proc.newXsltCompiler();
StreamSource styleSource = new StreamSource(xsltFile);
StreamSource xmlSource = new StreamSource(xmlFile);
String msg="";
XsltExecutable templates = comp.compile(styleSource);
XsltTransformer transformer = templates.load();
transformer.setSource(xmlSource);
transformer.setMessageListener(new MessageListener(){
@Override
public void message (XdmNode content, boolean terminate, SourceLocator locator){
try{
if (content.getTypedValue!= null){
msg += content.getTypedValue().toString() + "\n";
}}
catch (SaxonApiException ex){
Logger.getLogger(...);
}
}
});
Writer write = new StringWriter();
Serializer out = proc.newSerializer(write);
transformer.setDestination(out);
transformer.transform();
textAreaOut.setText(msg);