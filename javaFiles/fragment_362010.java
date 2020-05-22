public class JavaOnlineCompiler {

       public static void main(String[] args) {
          ChildClass cc = new ChildClass();

          cc.ar = new Room[] { // attempt to initialize arr
                cc.new Room(10), cc.new Room(29)
          };
       }

    }

    class ChildClass {

       public class Room {
          int size;

          public Room(int v) {
             this.size = v;
          }
       }

       public Room[] ar;
    }