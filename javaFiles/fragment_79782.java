String isogram = "salad";
boolean isIsogram = true;
for ( int i = 0; i < isogram.length(); i++ ) {
    for ( int j = 0; j < isogram.length(); j++ ) {
        if ( i != j && isogram.charAt( i ) == isogram.charAt( j ) && ( Character.isLetter( isogram.charAt( i ) ) ) ) {
            isIsogram = false;
        }
    }
}
System.out.println( isIsogram );