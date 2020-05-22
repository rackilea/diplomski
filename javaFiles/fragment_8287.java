Graph get(Key key) {
    Graph result = get( key );
    if( null == result ) {
        result = createNewGraph( key );
        put( key, result );
    }
    return result;
}