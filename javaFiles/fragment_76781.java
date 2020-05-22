final Class<?> clazz = Class.forName("com.your.SampleClass");
    final Method[] declaredMethods = clazz.getDeclaredMethods();
    for (final Method method : declaredMethods)
    {
        if (method.isAnnotationPresent(YourAnnotationClass .class))
        {
            //Do what you want
        }
    }