import java.io.*;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(ServiceResult.class, ObjectFactory.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        StringReader xml = new StringReader("<serviceResult><simpleObj/><unmapped/><simpleObjJAXBElement/></serviceResult>");
        ServiceResult result = (ServiceResult) unmarshaller.unmarshal(xml);

        for(Object item : result.getBody()) {
            System.out.println(item.getClass());
        }
    }

}