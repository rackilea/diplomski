public class Foo {

    public void printAMessage() {
    System.out.println(toString()+":a message");
    }
    public void printAnotherMessage(String theString) {
        System.out.println(toString()+":another message:" + theString);
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("Foo");
            Method method1 = c.getDeclaredMethod("printAMessage", new Class[]{});
            Method method2 = c.getDeclaredMethod("printAnotherMessage", new Class[]{String.class});
            Object o = c.newInstance();
            System.out.println("this is my instance:" + o.toString());
            method1.invoke(o);
            method2.invoke(o, "this is my message, from a config file, of course");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException nsme){
            nsme.printStackTrace();
        } catch (IllegalAccessException iae) {
            iae.printStackTrace();
        } catch (InstantiationException ie) {
            ie.printStackTrace();
        } catch (InvocationTargetException ite) {
            ite.printStackTrace();
        }
    }
}