try
    {
        method.invoke(Hello.class, "random");
    }
    catch (InvocationTargetException e)
    {
        throw e.getTargetException();
    }