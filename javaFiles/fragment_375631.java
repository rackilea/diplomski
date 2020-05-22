String className = errorInfo.getClassName();
    String methodName = errorInfo.getMethodName();
    String requestMessage = errorInfo.getMessage();
    String reference3 = errorInfo.getReference3();

    try {
        Class<?> claz = Class.forName(className);
        Object obj = claz.newInstance();
        Class[] parameterTypes = new Class[1];
        Class<?> parameter = Class.forName(reference3);
        parameterTypes[0] = parameter;
        Method method = claz.getMethod(methodName, parameterTypes);
        method.invoke(obj, new 
        ObjectMapper().readValue(requestMessage,parameter));

    } catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }