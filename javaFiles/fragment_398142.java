import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class A {

    private List<B> b;
    private int c;

    public List<B> getB() {
        return b;
    }

    public void setB(List<B> b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
        A a = new A();
        ObjectMapper mapper = new ObjectMapper();
        String temp = mapper.writeValueAsString(a);
        System.out.println(temp);   
    }
}

class B{


}