public static void main( String[] args ) {
    int gradeOne = 75, gradeTwo = 80, testScore = ( ( gradeOne + gradeTwo ) / 2 );
    char grade;

    if( testScore >= 90 ) {
        grade = 'A';
    } else if( testScore >= 80 ) {
        grade = 'B';
    } else if( testScore >= 70 ) {
        grade = 'C';
    } else if( testScore >= 65 ) {
        grade = 'D';
    } else {
        grade = 'F';
    }
    System.out.println( "\n" + "your test score is: " + testScore );
}