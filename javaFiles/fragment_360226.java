while( rs.next() ) { 
    list.add( createFrom( rs ) );
}

...

public Object createFrom( ResultSet rs ) {  // Here rs is a copy of the reference in the while above. 
}