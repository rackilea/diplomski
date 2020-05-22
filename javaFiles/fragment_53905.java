public void printInt() throws Exception {
    Class<? extends SuperClass> clazz = getClass();

    // Use superclass method by default
    Method theGetInt = SuperClass.class.getDeclaredMethod("getInt");

    // Look for a subclass method
    Class<?> classWithGetInt = clazz;
    OUTER: while( classWithGetInt != SuperClass.class ){

        for( Method method : classWithGetInt.getDeclaredMethods() )
            if( method.getName().equals("getInt") && method.getParameterTypes().length == 0 ){
                theGetInt = method;
                break OUTER;
            }

        // Check superclass if not found
        classWithGetInt = classWithGetInt.getSuperclass();
    }

    System.out.println("I am " + classWithGetInt + ". The int is " + theGetInt.invoke(this) );
}