public class PI {
    public static void main( String[] args) {
        double PI4 = 1.0;
        for ( int i = 1 ; i <= 50 ; i++ ) {
            double nom = Math.pow( -1, i );
            double denom = 2 * i + 1;
            PI4 += nom / denom;
        }
        System.out.println( "result=" + PI4 * 4 );
    }

}