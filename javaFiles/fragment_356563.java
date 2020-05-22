import java.lang.reflect.Field;

public class Reflection {

    MyObject myObject1 = new MyObject("1");
    MyObject myObject2 = new MyObject("2");
    MyObject myObject3 = new MyObject("3");

    public MyObject getMyObject(final String string) {
        try {
            final Field declaredField = this.getClass()
                    .getDeclaredField(string);
            final Object o = declaredField.get(this);
            if (o instanceof MyObject) {
                return (MyObject) o;
            }

        } catch (final Exception e) {
        }
        return null;
    }

    class MyObject {
        final String name;

        public MyObject(final String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return name;
        }

    }

    public static void main(final String[] args) {
        final Reflection r = new Reflection();
        System.out.println(r.getMyObject("myObject1"));
        System.out.println(r.getMyObject("myObject2"));
        System.out.println(r.getMyObject("myObject3"));
        System.out.println(r.getMyObject("invalid"));
    }

}