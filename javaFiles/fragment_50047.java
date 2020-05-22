import java.util.ArrayList;

class MyClass {
    ArrayList<String> stringList;

    public ArrayList<String> getStringList() {
        return stringList;
    }
}

public class Foo {
    public static void main(String... args) throws NoSuchMethodException {
        ArrayList<Integer> intList = new ArrayList<>();
        System.out.println(intList.getClass().toGenericString());  
        System.out.println(MyClass.class.getMethod("getStringList").toGenericString());
    }
}