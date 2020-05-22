public static void main(String[] args) {
    TestClass<Byte> test = new TestClass<Byte>(Byte.class);
    // No ClassCastException here
    Byte[] array = test.getArray();
    System.out.println(Arrays.asList(array));
}