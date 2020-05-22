for( int i = 0; i < students.size(); ++i ){
    Student s = students.get( i );
    if( "Anton".equals( s.getName() ) ){
        students.delete( i );
        break;
    }
}