XStream xstream = new XStream(
           new DomDriver() {
               public HierarchicalStreamWriter createWriter(Writer out) {
                   return new MyWriter(out);}});
String xml = xstream.toXML(myObj);

    ......

public class MyWriter extends PrettyPrintWriter {
    public MyWriter(Writer writer) {
        super(writer);
    }

    protected void writeText(QuickWriter writer, String text) { 
        if (text.indexOf('<') < 0) {
            writer.write(text);
        }
        else { 
            writer.write("<[CDATA["); writer.write(text); writer.write("]]>"); 
        }
    }
}