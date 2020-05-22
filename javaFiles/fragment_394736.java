public static long gapInMillis( String gap ){
    String[] hms = gap.split( ":" );
    return ((Integer.valueOf( hms[0] ) * 60 +
             Integer.valueOf( hms[1] )) * 60 +
             Integer.valueOf( hms[2] )) * 1000;
}

public static void main(String args[] ) throws Exception {
    Date now = new Date();
    Date nowMinusGap = new Date( now.getTime() - gapInMillis( gap ) );
    System.out.println( nowMinusGap + " - " + now );
}