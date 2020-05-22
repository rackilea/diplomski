boolean compare( List<?> list, Set<?> set ){
    if( list.size() != set.size() ){
        System.out.println( "different sizes" );
        return false;
    for( Object obj: list ){
        if( ! set.contains( obj ) ){
            System.out.println( obj + "not in set" );
            return false;
        }
    }
    return true;
}