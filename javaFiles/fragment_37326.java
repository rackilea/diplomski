public class Test {    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String jsonData = "This is a json {\"name\":\"jim\",\"age\":12,\"contactDetails\": {\"phone\":\"xxxxx\"}} json ended";
        System.out.println(jsonData.substring(jsonData.indexOf("{"), jsonData.lastIndexOf("}") + 1));

    }
}