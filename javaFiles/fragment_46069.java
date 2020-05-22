public class Main {
    public final String mainStr = "Hello";

    public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
        final ObjectMapper om = new ObjectMapper();
        System.out.println("Serialized Main: " + om.writeValueAsString(new Main()));
        System.out.println("Serialized A: " + om.writeValueAsString(new A()));
        System.out.println("Serialized AA: " + om.writeValueAsString(new AA()));
        System.out.println("Serialized B: " + om.writeValueAsString(new B()));
        System.out.println("Serialized List of A: " + om.writeValueAsString(Collections.singletonList(new A())));
    }

    static class A extends Main {
        public final String aStr = "World";
        public final int aInt = 42;
    }

    static class AA extends A {
        public final String aaStr = "Foo";
    }

    static class B {
        public final String bStr = "Bar";
        public final boolean bBool = true;
    }
}