static Object instantiate(List<String> args, String className) throws Exception {
    // Load the class.
    Class<?> clazz = Class.forName(className);

    // Search for an "appropriate" constructor.
    for (Constructor<?> ctor : clazz.getConstructors()) {
        Class<?>[] paramTypes = ctor.getParameterTypes();

        // If the arity matches, let's use it.
        if (args.size() == paramTypes.length) {

            // Convert the String arguments into the parameters' types.
            Object[] convertedArgs = new Object[args.size()];
            for (int i = 0; i < convertedArgs.length; i++) {
                convertedArgs[i] = convert(paramTypes[i], args.get(i));
            }

            // Instantiate the object with the converted arguments.
            return ctor.newInstance(convertedArgs);
        }
    }

    throw new IllegalArgumentException("Don't know how to instantiate " + className);
}