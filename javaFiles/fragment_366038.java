ArrayList<Object> list = new ArrayList<Object>();

try {
    while ( true )
        list.add( new Object() );
} catch ( OutOfMemoryError e ) {
    // And we are done...
}