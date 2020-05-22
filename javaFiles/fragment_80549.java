import java.io.*;
    public class SerializeDemo {

       public static void main(String [] args) {
          private static int FOO_COUNT = 0;

          try {
             FileOutputStream fileOut =
             new FileOutputStream("/tmp/save.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut);
             out.writeObject(FOO_COUNT);
             out.close();
             fileOut.close();
             System.out.printf("Serialized data is saved in /tmp/save.ser");
          } catch (IOException i) {
             i.printStackTrace();
          }
       }
    }


    public class Foo  implements java.io.Serializable  {
        private static int FOO_COUNT = 0

        public static getNextCount(){
            return ++FOO_COUNT;
        }
        //... more methods...
    }