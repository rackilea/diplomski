public static void main(String... args) throws Exception, ClassNotFoundException {
    String classAndMethod = args[0];
    Request request = Request.aClass(Class.forName(classAndMethod));
    Result result = new JUnitCore().run(request);
    afterClass();
}