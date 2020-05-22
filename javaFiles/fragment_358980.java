class ClassB extends ClassA {
    public static void main(String[] args) {

        ClassA.Builder.hello();
        ClassA.Builder builder = new Builder();
        builder.hello1();

    }
}