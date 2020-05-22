String methodName = "methodToCall"; // get this from your Excel spreadsheet.
    Integer value = 17; // Get this from your Excel spreadsheet.
    GenericClass classInstance = new GenericClass();

    try {
        Method method = GenericClass.class.getDeclaredMethod(methodName, Integer.class);
        method.invoke(classInstance, value);
    } catch (Exception e) {
        // Handle the exception.
    }