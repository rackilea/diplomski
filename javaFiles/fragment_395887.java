Bean c1 = new Bean();

    c1.setField1("Object 1");
    c1.setField2("Object 2");

    for (int count = 1; count < headers.length; count++) 
    {
        //concatenate to get method name
        String methodName = "getField" + count;

        // using reflection, get collection of all methods in Bean class
        Method[] methods = Bean.class.getMethods();

        for(Method method : methods)
        {
            if (method.getName().equals(methodName))
            {
                // if it's the method you want, invoke it using 
                // the required params
                method.invoke("Parameter_" + count, messages.getString("field." + headers[count]));
            }
        }
    }