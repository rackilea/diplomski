import java.io.*;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(ServiceResult.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        StringReader xml = new StringReader("<serviceResult><simpleObj/><simpleObj/></serviceResult>");
        ServiceResult result = (ServiceResult) unmarshaller.unmarshal(xml);

        for(Object item : result.getBody()) {
            System.out.println(item.getClass());
        }
    }

}