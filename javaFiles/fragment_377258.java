String namespace = "http://my-namespace";
Element request = new Element("request", namespace);

Element type = new Element("type", namespace);
type.appendChild("Test");

request.appendChild(type);

Element data = new Element("data", namespace);
request.appendChild(data);

Element myData = new Element("myData", namespace);
myData.appendChild("test data");
data.appendChild(myData);

Document doc = new Document(request);
System.out.println(doc.toXML());