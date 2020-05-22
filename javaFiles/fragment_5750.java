public <T> void parse(Class<T> clazz, T obj) throws Exception {
    Method[] methods = clazz.getMethods();
    int pass = 0;
    int fail = 0;

    for (Method method : methods) {
        if (method.isAnnotationPresent(Test.class)) {
            Test test = method.getAnnotation(Test.class);
            Class expected = test.expected();
            try {
                method.invoke(obj);
                pass++;
            } catch (Exception e) {
                if (Exception.class != expected) {
                    e.printStackTrace();
                    fail++;
                } else {
                    pass++;
                }
            }
        }
    }
    System.out.println("Passed:" + pass + "   Fail:" + fail);
}

...

parser.parse(MyTest.class, new MyTest());