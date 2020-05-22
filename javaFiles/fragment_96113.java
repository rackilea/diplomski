public static boolean objectHasToStringImplemented( final Object o ){
    return classHasToStringImplemented( o.getClass() );
}


public static boolean classHasToStringImplemented( final Class<?> initialClass ){

    Class<?> classToCheck = initialClass;
    while( classToCheck != Object.class ){
        if(  classImplementsToString( classToCheck )  ){
            return true;
        }

        classToCheck = classToCheck.getSuperclass();
    }

    return false;
}


private boolean classImplementsToString( final Class<?> aClass ){
    try{
        aClass.getDeclaredMethod( "toString" );
        return true;

    }catch( NoSuchMethodException e ){
        return false;

    }
}