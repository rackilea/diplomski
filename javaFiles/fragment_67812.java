import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) throws Exception {
        String json = "[\"a\",\"b\",\"c\"]";

        ObjectMapper mapper = new ObjectMapper();
        OuterElement outerElement = mapper.readValue(json, OuterElement.class);

        System.out.println(outerElement);
    }
}

class Element {

    private String value;

    public Element(String value) {
        this.value = value;
    }

    // getters, setters, toString
}

class OuterElement {

    private Element[] elements;

    @JsonCreator
    public OuterElement(List<String> elements) {
        this.elements = new Element[elements.size()];
        int index = 0;
        for (String element : elements) {
            this.elements[index++] = new Element(element);
        }
    }

    // getters, setters, toString
}