class TestClass1 {
    public TestClass1() {
        System.out.println("TestClass1");
    }
}

class TestClass2 extends TestClass1 implements Serializable {
    public TestClass2() {
        System.out.println("TestClass2");
    }
}

public static void main(String[] args) throws Exception {
    System.out.println("Object construction via calling new keyword");
    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("resources/dummy.dat"));
    out.writeObject(new TestClass2());

    System.out.println("Object construction via readObject method");
    ObjectInputStream is = new ObjectInputStream(new FileInputStream("resources/dummy.dat"));
    TestClass2 tc = (TestClass2) is.readObject();
}