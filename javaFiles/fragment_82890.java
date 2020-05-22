import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;

public class Json {

    public static void main(String[] args) throws Exception {
        File jsonFile = new File("test.json");

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        ObjectNode root = (ObjectNode) mapper.readTree(jsonFile);

        // create new node item
        ObjectNode newNode = new ObjectNode(mapper.getNodeFactory());
        newNode.put("data1", 3);
        newNode.put("data2", "DATA3");

        // create new class item
        FirstItem newItem = new FirstItem(4, "DATA4");

        // get array node
        ArrayNode firstArray = (ArrayNode) root.get("firstArray");

        // add new ObjectNode
        firstArray.add(newNode);

        // add new POJO
        firstArray.add(mapper.convertValue(newItem, JsonNode.class));

        // serialise root
        System.out.println(mapper.writeValueAsString(root));
    }
}

class FirstItem {

    private int data1;
    private String data2;

    public FirstItem(int data1, String data2) {
        this.data1 = data1;
        this.data2 = data2;
    }

    public int getData1() {
        return data1;
    }

    public String getData2() {
        return data2;
    }
}