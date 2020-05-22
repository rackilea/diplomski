for( int i = 0; i < targets.length; i++ ) {
        if( sources[i] == null )
            continue;

        if( !translateFromPrimitive( targets[i] ).isAssignableFrom( sources[i] ) )
            return false;
        }
    return( true );
}