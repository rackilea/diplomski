//NB: implementation is synchronized and thus thread-safe
private static final Hashtable<Class<?>,Boolean> cachedAnswers = new Hashtable<>();
static {
    cachedAnswers.put( Object.class, Boolean.FALSE );
}

public static Boolean objectHasToStringImplemented( final Object o ){
    return classHasToStringImplemented( o.getClass() );
}


public static Boolean classHasToStringImplemented( final Class<?> classToCheck ){
    if( cachedAnswers.containsKey( classToCheck )  ){
        return cachedAnswers.get( classToCheck );
    }

    final Boolean result = classImplementsToString( classToCheck )  ||  classHasToStringImplemented( classToCheck.getSuperclass() );
    cachedAnswers.put( classToCheck, result );

    return result;
}

private static Boolean classImplementsToString( final Class<?> aClass ){
    for( Method m : aClass.getDeclaredMethods() ){
        if(  isToString( m )  ){
            return Boolean.TRUE;
        }
    }

    return Boolean.FALSE;
}


private static Boolean isToString( final Method m ){
    if(  m.getParameterCount() == 0  && m.getName().equals( "toString" )  &&  m.getReturnType().equals( String.class )  ){
        return Boolean.TRUE;

    }else{
        return Boolean.FALSE;
    }
}