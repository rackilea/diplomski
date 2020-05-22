try {
    final Field field = this.getClass().getDeclaredField( "house" );
    final Spooky spooky = field.getAnnotation( Spooky.class );
    if ( spooky != null ) {
        System.out.printf( "@%s%n%s %s %s;%n",
            spooky.annotationType().getSimpleName(),
            Modifier.toString( field.getModifiers() ),
            field.getType().getSimpleName(),
            field.getName() );
    }
}
catch ( NoSuchFieldException | SecurityException e ) {
    e.printStackTrace();
}