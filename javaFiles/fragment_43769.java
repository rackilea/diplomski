class BeanFactory {
    private static final int LIMIT = 5;
    private static List<BeanTest> list = new ArrayList<BeanTest>();

    public static synchronized BeanTest getInstance(String name) {
        if (list.size() < LIMIT) {
            BeanTest beanTest = new BeanTest(name);
            list.add(beanTest);
            return beanTest;
        }
        System.out.println("Not giving instance");
        return null;
    }

}