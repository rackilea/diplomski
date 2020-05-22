public class Test {
    @Path("getCustomers")
    public void test() {

    }

    public static List<String> getMethodsAnnotatedWith(final Class<?> type) {
        final List<String> paths = Lists.newArrayList();
        Class<?> clazz = type;
        while (clazz != Object.class) {
            final List<Method> allMethods = new ArrayList<>(Arrays.asList(clazz.getDeclaredMethods()));
            for (final Method method : allMethods) {
                Path path = method.getAnnotation(Path.class);
                if(path != null) {
                    paths.add(path.value());
                }
            }
            // move to the upper class in the hierarchy in search for more methods
            clazz = clazz.getSuperclass();
        }
        return paths;
    }

    public static void main(String[] args) {
        System.out.println(getMethodsAnnotatedWith(Test.class));
    }

}