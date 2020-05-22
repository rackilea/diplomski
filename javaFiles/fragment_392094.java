public abstract class Test {

    // abstract class constructor
    public Test() {
        System.out.println("foo");
    }

    // concrete sub class
    public static class SubTest extends Test {    
      // no constructor defined, but implicitly calls no-arg constructor 
      // from parent class
    }

    public static void main(String[] args) throws Exception {
        Test foo = new Test(); // Not allowed (compiler error)
        SubTest bar = new SubTest(); // allowed, prints "foo"
    }
}