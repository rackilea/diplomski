public class Test
{
  static String randomXml =
      "<divisionRequestHeader xmlns=\"http://www.company.com/ns/\">"
        + "<id>fake id</id>"
        + "<CoName>My Co Name</CoName>" + "<User>"
        + "<Type>EXTERNAL</Type>" + "<Value>me</Value>" + "</User>"
        + "<Count>100</Count>"
        + "<Requestor>My App Requesting</Requestor>"
        + "</divisionRequestHeader>";

  public static void main(String[] args) throws Exception
  {
    JAXBContext context = JAXBContext.newInstance(DivisionRequestHeader.class);
    Unmarshaller unmarshaller = context.createUnmarshaller();
    Source source = new StreamSource(new StringReader(randomXml));

    JAXBElement<DivisionRequestHeader> jaxbElement = unmarshaller.unmarshal(source,
            DivisionRequestHeader.class);
    DivisionRequestHeader header = jaxbElement.getValue();

    System.out.println(header.toString());
  }
}