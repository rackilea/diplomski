interface Product {
    void doSomething();
}
interface Creator {
     Product create(String someData);
}
class ProductX implements Product {
    public void doSomething() {
         System.out.println("X");
    }
}
class ProductY implements Product {
    public void doSomething() {
         System.out.println("y");
    }
}
class XYFactory implements Creator {
    public Product create(String someData) {
        if ("X".equals(someData)) {
            return new ProductX();
        }
        if ("Y".equals(someData)) {
            return new ProductY();
        }
        return null;
    }
}