public class Test {
    public static void main(String[] args) {
        MyEnum.VALUE_1.createInnerObject().showName();
        MyEnum.VALUE_2.createInnerObject().showName();
    }

    public enum MyEnum {
        VALUE_1, VALUE_2;

        public MyInnerClass createInnerObject() {
            return new MyInnerClass();
        }

        private class MyInnerClass {
            public void showName() {
                System.out.println("Inner class assigned to " + MyEnum.this + " instance");
            }
        }
    }
}