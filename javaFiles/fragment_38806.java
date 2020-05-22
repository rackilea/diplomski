public enum MyEnum{
    INSTANCE_A,
    INSTANCE_B;

    public class MyInnerClass {
        // This is no different from the inner class in a normal class

        public String show() {
            // You can get the name of the instance for which this method was called.
            System.out.println(MyEnum.this.name());
            return "Hello";
        }
    }
}