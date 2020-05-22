public static void main(String... args) throws Exception {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(baos);
    oos.writeObject(new B());
    oos.writeObject(new D());
    oos.close();
    System.out.println("-------------");
    ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
    System.out.println("deserialize B");
    ois.readObject();
    System.out.println("deserialize D");
    ois.readObject();
}

static class A {
    public A() {
        System.out.println("Inside class A");
    }
}

static class B extends A  implements Serializable {
    public B() {
        System.out.println("Inside class B");
    }
}

static class C implements Serializable  {
    public C() {
        System.out.println("Inside class C");
    }
}

static class D extends C {
    public D() {
        System.out.println("Inside class D");
    }
}