// obtain an object instance
    MyObject myObjectInstance =  new MyObject();

    // get the field definition
    Field fieldDefinition = myObjectInstance.getClass().getDeclaredField("f");

    // make it accessible
    fieldDefinition.setAccessible(true);

    // obtain the field value from the object instance
    Object fieldValue = fieldDefinition.get(myObjectInstance);

    // get declared method
    Method myMethod =fieldValue.getClass().getDeclaredMethod("greatMethod", new Class[]{});

    // invoke method on the instance of the field from yor object instance
    myMethod.invoke(fieldValue);