import java.lang.reflect.Field;

public class Main {

    private static MyObject clone(MyObject p) {

        final MyObject clone = new MyObject();
        Field[] fields = p.getClass().getDeclaredFields();

        for (java.lang.reflect.Field field : fields) {

            // Boolean properties will hav eis prefix instead of get
            String getter = "get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
            String setter = "set" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
            java.lang.reflect.Method getterMethod;
            java.lang.reflect.Method setterMethod;

            try {
                getterMethod = p.getClass().getMethod(getter, null);
                Object valueGetted = getterMethod.invoke(p, null);

                Class[] paramForSetter = new Class[1];
                paramForSetter[0] = valueGetted.getClass();

                setterMethod = p.getClass().getMethod(setter, field.getType());
                setterMethod.invoke(clone, valueGetted);

                System.out.println(" Successfully copied " + field.getName());

            } catch (Exception ex) {
                System.err.println(" Error copying " + field.getName() + ": " + ex.getMessage());
            }
        }
        return clone;
    }

    public static void main(String[] args) {
        MyObject m = new MyObject(1, 2L, "3", true);
        System.out.println("Main.main: Original = " + m);
        MyObject c = clone(m);
        System.out.println("Main.main: Clone = " + c);
    }

}

class MyObject {

    private int myInt;
    private Long myLong;
    private String myString;
    private Boolean myBool;

    MyObject() {
    }

    MyObject(int myInt, Long myLong, String myString, Boolean myBool) {
        this.myInt = myInt;
        this.myLong = myLong;
        this.myString = myString;
        this.myBool = myBool;
    }

    public int getMyInt() {
        return myInt;
    }

    public void setMyInt(int myInt) {
        this.myInt = myInt;
    }

    public Long getMyLong() {
        return myLong;
    }

    public void setMyLong(Long myLong) {
        this.myLong = myLong;
    }

    public String getMyString() {
        return myString;
    }

    public void setMyString(String myString) {
        this.myString = myString;
    }

    public Boolean isMyBool() {
        return myBool;
    }

    public void setMyBool(Boolean myBool) {
        this.myBool = myBool;
    }

    @Override
    public String toString() {
        return "MyObject{" +
                "myInt=" + myInt +
                ", myLong=" + myLong +
                ", myString='" + myString + '\'' +
                ", myBool=" + myBool +
                '}';
    }
}