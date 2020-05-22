try {
   ...do some stuff
} catch( Exception e ) {
    if( e instanceof NullpointerException ) {
        ... do something
    } else if( e instanceof IOExceptio ) {
        ... do something else 
    }
}