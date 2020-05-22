import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {
    public static void main(String[] args) {
        Address addressObj = new Address();
        addressObj.setCity("Chicago");
        addressObj.setStreet("Some Street");
        addressObj.setZip(12345);

        Id idObj = new Id();
        idObj.setAddr(addressObj);
        idObj.setFname("Test");
        idObj.setLname("Tester");

        ObjectMapper mapper = new ObjectMapper();

        //Object to JSON in String
        try {
            String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(idObj);
            System.out.println(jsonInString);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }       
    }
}