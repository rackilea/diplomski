public static void main(String[] args) throws Exception {
    for( int i = 100; i <= 199; ++i ){
        int invi = invert( i );
        if( invi > 0 ){
            System.out.println( i + ": " + invi );
        }
    }
}