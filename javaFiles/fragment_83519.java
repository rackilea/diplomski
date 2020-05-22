void getName() {
    try {
        Class c = Class.forName("com.test1");
        Object o = c.newInstance();
        System.out.println(o);

        // The next two lines replace the MethodUtils call
        Method getValueMethod = c.getMethod("getValue");
        String value = getValueMethod.invoke(o);

        System.out.println("Results from getValue: " + value);
    } catch (Exception e) {
        e.printStackTrace();
    }
}