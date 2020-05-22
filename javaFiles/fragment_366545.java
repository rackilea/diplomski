import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;

        public class Main {



        public String toStringMethod(TestObject test) {
            String serializedObject = "";
            try {
                ByteArrayOutputStream bo = new ByteArrayOutputStream();
                ObjectOutputStream so = new ObjectOutputStream(bo);
                so.writeObject(test);
                so.flush();
                so.close();
                serializedObject = bo.toString("windows-1252");
                System.out.println(serializedObject);
            } catch (Exception e) {
                System.out.println(e);
            }
            return serializedObject;

        }

        public TestObject toObjectMethod(String string) {
            String serializedObject = string;
            TestObject obj = null;
            try {
                byte b[] = serializedObject.getBytes("windows-1252");
                ByteArrayInputStream bi = new ByteArrayInputStream(b);
                ObjectInputStream si = new ObjectInputStream(bi);
                obj = (TestObject) si.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return obj;

        }

        public static void main(String[] args) {

            Main mn = new Main();

            TestObject object = new TestObject();

            object.setString(10);

            String str = mn.toStringMethod(object);

            TestObject newObject = mn.toObjectMethod(str);

            newObject.printHello();
        }



    }

    class TestObject implements Serializable{

        char chars[];
        String str;

        public String setString(int numberOfBytes) {

            numberOfBytes = numberOfBytes/2;

            chars = new char[numberOfBytes];
            Arrays.fill(chars, 'a');
            str = new String(chars);
            return str;
        }

        public String getString() {

            return str;
        }

        public void printHello() {
            System.out.println("hello tester");
        }

    }