public class Test1 {
private String f;
private String b;

public void setFoo(String v) { f = v; }

public void setBim(String v) { b = v; }

public String toString() { return "f=" + f + ", b=" + b; }


public static void main(String[] args) throws Exception {
    String test = "{ \"foo\":\"bar\", \"bim\":\"baz\" }";
    ObjectMapper mapper = new ObjectMapper();
    HashMap map = mapper.readValue(new StringReader(test), HashMap.class);
    System.out.println(map);
    Test1 test1 = mapper.convertValue(map, Test1.class);
    System.out.println(test1);
}
}