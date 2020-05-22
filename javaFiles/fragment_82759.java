private Method searchForMethod( String name, Class[] parms ) {
    Method[] methods = type.getMethods();
    for( int i = 0; i < methods.length; i++ ) {
        // Has to be named the same of course.
        if( !methods[i].getName().equals( name ) )
            continue;

        Class[] types = methods[i].getParameterTypes();

        // Does it have the same number of arguments that we're looking for.
        if( types.length != parms.length )
            continue;

        // Check for type compatibility
        if( InspectionUtils.areTypesCompatible( types, parms ) )
            return methods[i];
        }
    return null;
}