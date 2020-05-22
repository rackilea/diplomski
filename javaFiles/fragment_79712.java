import java.util.*;

public class Demo {

    public static void main(String[] args) {
        List<String> scripts = new ArrayList<String>();
        scripts.add("foo");
        scripts.add("bar");

        for(int x=0,size=scripts.size(); x<size; x++) {
            scripts.set(x, "dummy");
        }

        for(String script : scripts) {
            System.out.println(script);
        }
    }

}