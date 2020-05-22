import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class App {
    public static void main(final String[] args) throws IOException {
        final MyType myType = new MyType();
        myType.setField1("blah");
        myType.setField2(311);

        final MyObject<MyType> myObj = new MyObject<>();
        myObj.setX(10);
        myObj.setY("why oh why");
        myObj.setCustomObject(myType);

        final ObjectMapper mapper = new ObjectMapper();
        final String json = mapper.writeValueAsString(myObj);
        System.out.println(json);

        final TypeReference<MyObject<MyType>> typeRef = new TypeReference<MyObject<MyType>>() {};

        final MyObject<MyType> myObj2 = mapper.readValue(json, typeRef);
        System.out.println("x: " + myObj2.getX());
        System.out.println("y: " + myObj2.getY());
        System.out.println("customObject:");
        System.out.println("   " + myObj2.getCustomObject().getField1());
        System.out.println("   " + myObj2.getCustomObject().getField2());
    }

    public static class MyType {
        private String field1;
        private int field2;

        public String getField1() { return field1; }
        public void setField1(final String field1) { this.field1 = field1; }

        public int getField2() { return field2; }
        public void setField2(final int field2) { this.field2 = field2; }
    }

    public static class MyObject<T> {
        private int x;
        private String y;
        private T customObject;

        public int getX() { return x; }
        public void setX(final int x) { this.x = x; }

        public String getY() { return y; }
        public void setY(final String y) { this.y = y; }

        public T getCustomObject() { return customObject; }
        public void setCustomObject(final T customObject) { this.customObject = customObject; }
    }
}