for (Method method : clazz.getMethods()) {
    String name = method.getName();
    if ( name.startsWith( "get" ) ) {
        properties.add( Introspector.decapitalize( name.substring( "get".length() ) ) );
    }
    else if ( name.startsWith( "is" ) ) {
        properties.add( Introspector.decapitalize( name.substring( "is".length() ) ) );
    }
}