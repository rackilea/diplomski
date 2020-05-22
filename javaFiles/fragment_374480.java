import netscape.javascript.*;

public class MyClass implements Serializable {
public String a;
public String b;

    public JavaDog(JSObject o) {
        this.a= (String)o.getMember("a");
        this.b = (String)o.getMember("b");
    }
}