public class Main {

    public static class TestRef {
        public String a;
        public int b;

        //Copy constructor
        public TestRef(TestRef other) {
            this(other.a, other.b);
        }

        public TestRef(String a, int b) {
            this.a = a;
            this.b = b;
        }

    }

    public static void main(String[] args) throws IOException, TransformerException {

        TestRef testRef = new TestRef("TestRef", 1);
        //Using copyConstructor to make deep copy of object
        System.out.println(testRef.a);
        TestRef deepCopy = new TestRef(testRef);
        modifyClass(deepCopy);
        System.out.println(testRef.a);
        //Shallow copy
        TestRef otherRef = testRef;
        modifyClass(otherRef);
        System.out.println(testRef.a);      
    }

    public static void modifyClass(TestRef testRef) {
        testRef.a = "newString";
        testRef.b++;
    }
}