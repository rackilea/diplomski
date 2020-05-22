import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class AppRun {

  public static void main(String[] args) throws JAXBException {

      StringMatchDataObject stringMatchDataObject = new StringMatchDataObject();
      stringMatchDataObject.setDataType("data type");
      stringMatchDataObject.setMatch("STRING MATCH");
      stringMatchDataObject.setValue("value");

      JAXBContext context = JAXBContext.newInstance(StringMatchDataObject.class);
      Marshaller m = context.createMarshaller();
      m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      m.marshal(stringMatchDataObject, System.out);
  }

}