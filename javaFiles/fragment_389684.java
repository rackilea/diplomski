Class[] theFiles = new Class[31];
    theFiles[1] = Challenge_1_Whats_Your_Name.class;
    try {
        theFiles[1].getMethod("main", String[].class).invoke(args);
    } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
        e.printStackTrace();
    }