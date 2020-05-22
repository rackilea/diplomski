@Override 
public String updateStatusMulti( String xml_content ) {

  try{

    //"unmask" then xml
    xml_content = xml_content.replace('{', '<');
    xml_content = xml_content.replace('}', '>');

    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document doc = dBuilder.parse(new InputSource(new ByteArrayInputStream(xml_content.getBytes("utf-8"))));

    //optional, but recommended
    //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
    doc.getDocumentElement().normalize();

    NodeList nList = doc.getElementsByTagName("status");

    int nCount = nList.getLength();

    StatusInfo[] manyStatus = new StatusInfo[nCount];

    for (int index = 0; index < nCount; index++) {

      Node nNode = nList.item(index);

      //("\nCurrent Element :" + nNode.getNodeName());

      if (nNode.getNodeType() == Node.ELEMENT_NODE) {

        Element eElement = (Element) nNode;

        String id_customer    = eElement.getElementsByTagName("id_customer").item(0).getTextContent();
        String status_date    = eElement.getElementsByTagName("status_date").item(0).getTextContent();
        String status_message = eElement.getElementsByTagName("status_message").item(0).getTextContent();

        manyStatus[index].setId_customer( Long.valueOf(id_customer) );
        manyStatus[index].setStatus_date( status_date );
        manyStatus[index].setStatus_message( status_message );

      }
    }

    //return String.format( "DONE: ( %d )", nCount );


    //here is my wanted call
    return updateManyStatus( manyStatus );

  } catch (Exception e) {

    return "ERROR: " + e.getMessage(); //xml_content;

  }
}