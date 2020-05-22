for( Class c : birdClasses ) {
    if( c.getMethod("canHandle").invoke(null, args) ) {
        return c.instantiate(args);
    }
}
return new Bird0(args)