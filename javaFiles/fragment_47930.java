// The first parameter is the prefix of this namespace in your document. in your sample it's an empty string
Namespace ns = Namespace.getNamespace("", "http://www.xyz.com/q");

Element element = doc.getRootElement();
root.setDate(element.getChild("Date", ns).getValue());
root.setID(element.getChild("ID", ns).getValue());