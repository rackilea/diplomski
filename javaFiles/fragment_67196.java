public class AbstractDemo {

       public static void main(String[] args) {
          Concrete c = new Concrete();
          AClass a = (AClass) c;
          a.me();
       }

    }

    abstract class AClass {
       public void me() {
          System.out.println("Abstract parent");
       }
    }

    class Concrete extends AClass {

    }