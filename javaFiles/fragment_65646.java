public String DatabaseIdentifier() 
{
    String dbIdentifier=null ;
    try {
        //Creates a virtual file where is allowed for default the persistence.xml configurarion file
        File path= new File("src\\META-INF");

        //Using the xml libraries prepare the document to be read.
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(new File(path+"\\persistence.xml"));
        doc.getDocumentElement().normalize();

        //Gets the list of properties  contained in the persistence.xml file
        NodeList listProperties= doc.getElementsByTagName("property");

        //We searching in the list of properties the attribute with the name 
        //eclipselink.target-database and there we get the database that 
        //is in use.
        for (int i = 0; i < listProperties.getLength(); i ++) {
            Node team = listProperties.item(i);

            if (team.getNodeType() == Node.ELEMENT_NODE)    
            {
                Element element = (Element) team;

            if (element.getAttribute("name").contains("eclipselink.target-database"))
                    {
                dbIdentifier=element.getAttribute("value").toString();
                System.out.println(element.getAttribute("value"));
                    }

            }
        }
    } catch (Exception e) 
    {e.printStackTrace();}
    return dbIdentifier;
}