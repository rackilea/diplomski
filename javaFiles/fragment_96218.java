public class Main{

  private String aField = "test";

  public static void main(String... args) {

    StaticExample x1 = new StaticExample();
    System.out.println(x1.getField());


    //does not compile:
    // NonStaticExample x2 = new NonStaticExample();

    Main m1 = new Main();
    NonStaticExample x2 = m1.new NonStaticExample();
    System.out.println(x2.getField());

  }


  private static class StaticExample {

    String getField(){
        //does not compile
        return aField;
    }
  }

  private class NonStaticExample {
    String getField(){
        return aField;
    }
  }