public static void main(String[] args) {

    Scanner s = new Scanner(System.in);
    String typeName = s.next();

    //ask for type

    Class<?> type;

    try {
        type = Class.forName(typeName);
    } catch (ClassNotFoundException e) {
        System.out.printf("Class `%s` was not found%n", typeName);
        return;
    }

    //discover constructors

    Constructor<?>[] constructors = type.getConstructors();

    for (int i = 0; i < constructors.length; ++i) {
        System.out.printf(" > %d %s%n", i, constructors[i]);
    }

    //select constructor and list its parameters

    int constructorIndex = s.nextInt();
    Constructor<?> constructor = constructors[constructorIndex];

    Type[] parameterTypes = constructor.getGenericParameterTypes();
    for (Type parameterType : parameterTypes) {
        System.out.println(parameterType);

        //each type implementation requires a specific processing

        if (parameterType instanceof Class) {
            Class parameterClass = (Class) parameterType;
            if ((parameterClass).isPrimitive()) {

                //simple int primitive; which can be directly obtained from scanner

                if (Integer.TYPE.isAssignableFrom(parameterClass)) {
                    System.out.println("\tinteger primitive > ");
                    int value = s.nextInt();
                    System.out.println("\t you've entered " + value);
                }
            } else {
                Stream.of((parameterClass).getConstructors()).forEach(c -> System.out.printf("\t%s%n", c));
                Stream.of((parameterClass).getDeclaredConstructors()).forEach(c -> System.out.printf("\t%s%n", c));
            }
        }
    }

    // here we consider a sample java.lang.Integer class was requested with #0 constructor

    if (Integer.class.isAssignableFrom(type) && constructorIndex == 0) {

        System.out.println("Input an integer number: ");

        String value = s.next();

        // since newInstance requires array of objects, we need to create an object (not primitive)

        Object instance;

        try {
            instance = constructor.newInstance(Integer.valueOf(value));
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
            return;
        }

        System.out.printf("%s %s%n", instance.getClass(), instance);
    }
}