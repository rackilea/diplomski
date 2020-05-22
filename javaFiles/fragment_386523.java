import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;

public class JsonApp {

  public static void main(String[] args) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    mapper.enable(SerializationFeature.INDENT_OUTPUT);
    mapper.setDefaultPropertyInclusion(Include.NON_NULL);

    System.out.println(mapper.writeValueAsString(new A()));
  }
}

class A {
  private B b = new B();

  public B getB() {
    return b;
  }

  public void setB(B b) {
    this.b = b;
  }
}

class B {
  private String c;

  public String getC() {
    return c;
  }

  public void setC(String c) {
    this.c = c;
  }
}