public class Driver {
    public static void main(String[] args) throws Exception {
        Class<?>[] classes = Driver.class.getDeclaredClasses();
        System.out.println(Arrays.toString(classes));
        for (Class<?> clazz : classes) {
            if (clazz.isAnnotation()) {
                Method[] methods = clazz.getDeclaredMethods();
                for (Method method : methods) {
                    System.out.println(method);
                }
            }
        }
    }

    @Retention(value=RetentionPolicy.RUNTIME)
    @Target(value=ElementType.FIELD)
    protected @interface Addition
    {
        String location();
    }
}