before() : execution(public static void main(..)) {
    try {
        Class<?>[] classes = { String.class, this.getClass(), Class.forName("com.BadReader") };
        for (Class<?> clazz : classes) {
            System.out.println(clazz);
            URL classURL = ClassFileHelper.getClassURL(clazz);
            System.out.println(classURL);
            System.out.println(ClassFileHelper.getJARFromURL(classURL));
            System.out.println();
        }
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
}