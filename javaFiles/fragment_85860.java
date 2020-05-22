import org.codehaus.jackson.map.ObjectMapper;

public class Main {
    public static void main(String[] args) {
        try {
            URL jsonURL = new URL("https://jchtest.herokuapp.com/index.php?PW=2");
            ObjectMapper mapper = new ObjectMapper();
            Users[] a1 = mapper.readValue(jsonURL, Users[].class);
            System.out.println(a1[0].getValues().getUserName());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}