int size = 4;
ArrayList<String> testArr = new ArrayList<String> ();
String[] test = null;

for ( int i = 0 ; i < size ; i ++ ) {
    testArr.add ( "test" );
    test = testArr.toArray ( new String[ 0 ] );
    System.out.println ( "i: " + i + " | test: " + Arrays.toString ( test ) );
}

System.out.println ( "test.length: " + test.length );