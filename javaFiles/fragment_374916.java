import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Test {

    public static void main(String[] args) {
        try{
            JAXBContext jc = JAXBContext.newInstance(Detail.class);

            Unmarshaller unmarshaller = jc.createUnmarshaller();
            File xml = new File("input.xml");
            Detail detail = (Detail) unmarshaller.unmarshal(xml);
            System.out.println("Detail firstname:"+detail.getFirstname()+" lastname:"+detail.getLastname());
        }
        catch(JAXBException e){
            System.out.println(e.getMessage());
        }
    }
}