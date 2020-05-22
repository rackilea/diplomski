RegExHashSet set = new RegExHashSet();
set.add( "hello" );
set.add( "my" );
set.add( "name" );
set.add( "is" );
set.add( "tangens" );

if( set.containsRegEx( "tan.*" ) ) {
    System.out.println( "it works" );
}