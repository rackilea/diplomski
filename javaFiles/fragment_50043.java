public class FindSubinterfaces {

    public static void main(String[] args) {
        Class clazz = A.class;

        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setUrls(Arrays.asList(ClasspathHelper.forClass(clazz))));

        Set<Class<? extends List>> subTypes = reflections.getSubTypesOf(clazz);
        for (Class c : subTypes) {
            if (c.isInterface()) {
                System.out.println("subType: " + c.getCanonicalName());
            }
        }
    }
}

interface A {
};

interface B extends A {
}

interface C extends A {
}

class CA implements A {
}

abstract class DC implements C {
}