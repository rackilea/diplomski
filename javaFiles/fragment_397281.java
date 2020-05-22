public class XMLwriter {
private ArrayList<String> names;
private Document doc;
private Random rand;
private ArrayList<Element> users;

public XMLwriter() throws ParserConfigurationException, TransformerException{

    DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
    doc = docBuilder.newDocument();

    rand = new Random();
    users = new ArrayList<Element>();
    names = new ArrayList<String>();

    names.add("Ralph Wiggum");names.add("Mr. Hanky");names.add("Bulbasaur");
    names.add("Tyroil Smoochie Wallace");names.add("Scooby Doo");names.add("Neville Longbottom");
    names.add("Jabba the Hutt");names.add("Silky Johnson");names.add("Master Chief");
    names.add("Frodo Baggins");names.add("Clayton Bigsby");names.add("John Snow");
    names.add("Eric Cartman");names.add("Leoz Maxwell Jilliumz");names.add("Aslan");

    createDoc();
    generateFile();

}

public void createDoc(){
    Element userList = doc.createElement("userList");//here, I create a new, over-arching element.
    for(int k = 0; k < names.size(); k++)
    {
        users.add(doc.createElement("user"));
    }
    for (int x = 0; x < 2; x++){

        //create the elements
        Element record = doc.createElement("record");
        users.get(x).appendChild(record);
        userList.appendChild(users.get(x));//I make each of the <user> elements a child of the over-arching element
        //The line that was throwing the error

        //create the attributes
        Attr name = doc.createAttribute("name");
        Attr date = doc.createAttribute("date");
        Attr project = doc.createAttribute("project");
        Attr time = doc.createAttribute("time");
        Attr id = doc.createAttribute("id");

        //give all of the attributes values
        name.setValue(names.get(x));
        date.setValue(new Date().toString());
        project.setValue("Project" + (rand.nextDouble() * 1000));
        time.setValue("" + rand.nextInt(10));
        id.setValue("" + (rand.nextDouble() * 10000));

        //assign the attributes to the elements
        users.get(x).setAttributeNode(name);
        record.setAttributeNode(date);
        record.setAttributeNode(project);
        record.setAttributeNode(time);
        record.setAttributeNode(id);


    }
    doc.appendChild(userList);//note how I append this child outside of the for loop
}

public void generateFile() throws TransformerException{
    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    Transformer transformer = transformerFactory.newTransformer();
    DOMSource source = new DOMSource(doc);
    StreamResult result = new StreamResult(new File("C:\\Users\\sweidenkopf\\workspace\\test\\testxml.xml"));

    // Output to console for testing
    // StreamResult result = new StreamResult(System.out);
    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
    transformer.transform(source, result);
}

}