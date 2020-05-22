List<Number> listofNumbers = new ArrayList<>();
for( String s: listOfStrings ){
    try {
        Number number = Enum.valueOf( Number.class, s );
        // or shorter:  Number.valueOf( s );     
        listOfNumbers.add( number );
    } catch( IllegalArgumentException iae ){
        // handle exception
    }
}