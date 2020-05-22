public Set<String> mergeSetsIfAnyOverlap( Set<String> s1, Set<String> s2 ) {
    Set<String> s3 = new HashSet<String>( s1 ) ;   // copy s3
    s3.retainAll( s1 ) ;                           // keep only things in s3 (aka s1 ) that exist in s2
    if( !s3.isEmpty() ) {                          // any common items ... ?
        s3.addAll( s1 ) ;                          // ... yes than merge 
    } else {
        s3.clear() ;                                // otherwise empty s3
    }
return s3 ;
}