import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {
    public String message="Nope";
    public String target="Nope";
    public String toString() {
        return message+" "+target+"!";
    }

    public static void main(String[] args) throws Exception {
        Test test=new Test();
        System.out.println(test);
        ObjectMapper mapper=new ObjectMapper();
        mapper.readerForUpdating(test).readValue("{\"message\":\"Hello\"}");
        System.out.println(test);
        mapper.readerForUpdating(test).readValue("{\"target\":\"World\"}");
        System.out.println(test);
    }
}